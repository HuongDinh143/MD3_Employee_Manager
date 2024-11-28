package ra.revise.service;

import ra.revise.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(String empId);
    boolean create(Employee employee);
    boolean update(Employee employee);
    boolean delete(String empId);
    List<Employee> findByDeptId(int deptId);
    List<Employee> searchEmployee(String keyword);
}
