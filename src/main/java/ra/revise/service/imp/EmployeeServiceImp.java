package ra.revise.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.revise.model.Employee;
import ra.revise.repository.DepartmentRepository;
import ra.revise.repository.EmployeeRepository;
import ra.revise.service.EmployeeService;

import java.util.List;
@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(String empId) {
        return employeeRepository.findById(empId);
    }

    @Override
    public boolean create(Employee employee) {
        return employeeRepository.create(employee);
    }

    @Override
    public boolean update(Employee employee) {
        return employeeRepository.update(employee);
    }

    @Override
    public boolean delete(String empId) {
        return employeeRepository.delete(empId);
    }

    @Override
    public List<Employee> findByDeptId(int deptId) {
        return employeeRepository.findByDeptId(deptId);
    }

    @Override
    public List<Employee> searchEmployee(String keyword) {
        return employeeRepository.searchEmployee(keyword);
    }
}
