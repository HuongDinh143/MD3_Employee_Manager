package ra.revise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.revise.model.Department;
import ra.revise.model.Employee;
import ra.revise.service.DepartmentService;
import ra.revise.service.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employeeController")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<Employee> listEmployees = employeeService.findAll();
        model.addAttribute("listEmployees", listEmployees);
        return "employee";
    }
    @GetMapping("/initCreate")
    public String initCreateEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);
        return "createEmployee";
    }
    @PostMapping("/create")
    public String createEmployee(Employee employee) {
        boolean result = employeeService.create(employee);
        if (result) {
            return "redirect:/employeeController/findAll";
        }
        return "error";
    }
    @PostMapping("/initUpdate")
    public String initUpdateEmployee(Model model, String empId) {
        Employee employeeUpdate = employeeService.findById(empId);
        model.addAttribute("employeeUpdate", employeeUpdate);
        List<Department> departments = departmentService.findAll();
        model.addAttribute("departments", departments);
        return "updateEmployee";
    }
    @PostMapping("/update")
    public String updateEmployee(Employee employee) {
        boolean result = employeeService.update(employee);
        if (result) {
            return "redirect:/employeeController/findAll";
        }
        return "error";
    }
    @GetMapping("/delete")
    public String deleteEmployee(String empId) {
        boolean result = employeeService.delete(empId);
        if (result) {
            return "redirect:/employeeController/findAll";
        }
        return "error";
    }
}
