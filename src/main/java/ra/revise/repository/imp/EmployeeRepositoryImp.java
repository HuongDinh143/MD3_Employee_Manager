package ra.revise.repository.imp;

import org.springframework.stereotype.Repository;
import ra.revise.model.Employee;
import ra.revise.repository.EmployeeRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
