package ra.revise.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.revise.model.Department;
import ra.revise.repository.DepartmentRepository;
import ra.revise.service.DepartmentService;

import java.util.List;

@Service
public class DepartmentServiceImp implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(int deptId) {
        return departmentRepository.findById(deptId);
    }

    @Override
    public boolean create(Department department) {
        return departmentRepository.create(department);
    }

    @Override
    public boolean update(Department department) {
        return departmentRepository.update(department);
    }

    @Override
    public boolean delete(int deptId) {
        return departmentRepository.delete(deptId);
    }
}
