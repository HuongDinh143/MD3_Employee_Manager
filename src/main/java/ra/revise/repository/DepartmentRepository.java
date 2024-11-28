package ra.revise.repository;

import ra.revise.model.Department;

import java.util.List;

public interface DepartmentRepository {
    List<Department> findAll();
    Department findById(int deptId);
    boolean create(Department department);
    boolean update(Department department);
    boolean delete(int deptId);
}
