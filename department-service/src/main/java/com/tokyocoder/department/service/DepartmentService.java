package com.tokyocoder.department.service;

import com.tokyocoder.department.entity.Department;
import com.tokyocoder.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department saveDepartment(Department department) {
        log.info("inside saveDepartment of DepartmentService");
        return departmentRepository.save(department);
    }


    public Department findByDepartmentId(Long departmentId) {
        log.info("inside findDepartmentById of DepartmentService");
        return  departmentRepository.findByDepartmentId(departmentId);
    }
}
