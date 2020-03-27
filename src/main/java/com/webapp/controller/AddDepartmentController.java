package com.webapp.controller;

import com.webapp.entity.Department;
import com.webapp.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddDepartmentController
{
    @Autowired
    DepartmentRepo departmentRepo;

    @GetMapping("/adddepartment")
    public String getDepartment()
    {
        return "adddepartment";
    }

    @PostMapping("/adddepartment")
    public String getDepartment(@RequestParam(name = "department") String department)
    {
        if (departmentRepo.findDepartmentByDepartment(department) != null)
            return "redirect:/adddepartment?error";
        departmentRepo.save(new Department(department));
        return "redirect:/addworker";
    }
}
