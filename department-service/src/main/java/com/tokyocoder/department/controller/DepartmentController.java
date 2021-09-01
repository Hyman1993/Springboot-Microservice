package com.tokyocoder.department.controller;

import com.tokyocoder.department.entity.Department;
import com.tokyocoder.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/")
    public Department saveDepartment(@RequestBody  Department department) {
        log.info("Inside saveDepartment method of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public  Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside saveDepartment method of DepartmentController");
        return departmentService.findByDepartmentId(departmentId);
    }
}
