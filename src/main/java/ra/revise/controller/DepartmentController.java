package ra.revise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ra.revise.model.Department;
import ra.revise.service.DepartmentService;

import java.util.List;

@Controller
@RequestMapping("/departmentController")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/findAll")
    public String findAllDepartment(Model model) {
        List<Department> listDepartments = departmentService.findAll();
       model.addAttribute("listDepartments", listDepartments);
        return "department";
    }
    @GetMapping("/initCreate")
    public String initCreateDepartment(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        return "createDepartment";
    }
    @PostMapping("/create")
    public String createDepartment(Department department) {
        boolean result =departmentService.create(department);
        if (result) {
            return "redirect:findAll";
        }else {
            return "error";
        }
    }
    @GetMapping("/initUpdate")
    public String initUpdateDepartment(Model model, int deptId) {
        Department departmentUpdate = departmentService.findById(deptId);
        model.addAttribute("departmentUpdate", departmentUpdate);
        return "updateDepartment";
    }
    @PostMapping("/update")
    public String updateDepartment(Department department) {
        boolean result =departmentService.update(department);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }
    @GetMapping("/delete")
    public String deleteDepartment(int deptId) {
        boolean result =departmentService.delete(deptId);
        if (result) {
            return "redirect:findAll";
        }
        return "error";
    }
}
