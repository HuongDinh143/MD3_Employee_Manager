package ra.revise.repository.imp;

import org.springframework.stereotype.Repository;
import ra.revise.model.Employee;
import ra.revise.repository.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class EmployeeRepositoryImp implements EmployeeRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public Employee findById(String empId) {
        return entityManager.createQuery("from Employee where empId = :empId", Employee.class)
                .setParameter("empId", empId).getSingleResult();
    }

    @Override
    @Transactional
    public boolean create(Employee employee) {
        try {
            entityManager.persist(employee);
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Employee employee) {
        try {
            entityManager.merge(employee);
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(String empId) {
        try {
            Employee employeeDelete = findById(empId);
            entityManager.remove(employeeDelete);
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public List<Employee> findByDeptId(int deptId) {
        return entityManager.createQuery("from Employee where department.deptId=:deptId",Employee.class)
                .setParameter("deptId", deptId).getResultList();
    }

    public List<Employee> searchEmployee(String keyword) {
        int age = -1;
        try {
            age = Integer.parseInt(keyword);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        String queryStr = "from Employee e where e.empName like :keyword " +
                "or e.empEmail like :keyword " +
                (age != -1 ? "or e.age = :age " : "") +
                "or cast(e.sex as string) like :keyword";

        TypedQuery<Employee> query = entityManager.createQuery(queryStr, Employee.class)
                .setParameter("keyword", "%" + keyword + "%");

        if (age != -1) {
            query.setParameter("age", age);
        }

        return query.getResultList();
    }

}
