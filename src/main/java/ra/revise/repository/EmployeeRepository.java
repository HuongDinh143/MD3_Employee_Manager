package ra.revise.repository;

import ra.revise.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();
    Employee findById(String empId);
    boolean create(Employee employee);
    boolean update(Employee employee);
    boolean delete(String empId);
}
