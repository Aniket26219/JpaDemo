package com.jpademo.jpademo.controller;

import com.jpademo.jpademo.model.Department;
import com.jpademo.jpademo.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    DepartmentRepo departmentRepo;

    @PostMapping(value = "savedata")
    public String saveData(@RequestBody Department department){
        departmentRepo.save(department);
        return "Data Saved";
    }
}
