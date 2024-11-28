package ra.revise.repository.imp;

import org.springframework.stereotype.Repository;
import ra.revise.model.Department;
import ra.revise.repository.DepartmentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Repository
public class DepartmentRepositoryImp implements DepartmentRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Department> findAll() {
        return entityManager.createQuery("from Department", Department.class).getResultList();
    }

    @Override
    public Department findById(int deptId) {
        return entityManager.createQuery("from Department where deptId = :id", Department.class)
                .setParameter("id", deptId).getSingleResult();
    }

    @Override
    @Transactional
    public boolean create(Department department) {
        try {
            entityManager.persist(department);
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean update(Department department) {
        try {
            entityManager.merge(department);
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    @Transactional
    public boolean delete(int deptId) {
        try {
            Department deleteDepartment = findById(deptId);
            entityManager.remove(deleteDepartment);
            return true;
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
