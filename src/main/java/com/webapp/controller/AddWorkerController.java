package com.webapp.controller;

import com.webapp.entity.Department;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repo.DepartmentRepo;
import com.webapp.repo.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class AddWorkerController
{
    @Autowired
    WorkerRepo workerRepo;

    @Autowired
    DepartmentRepo departmentRepo;

    @GetMapping("/addworker")
    public String getAdd(Model model, @AuthenticationPrincipal Worker worker)
    {
        model.addAttribute("roles", Role.values());
        model.addAttribute("department", departmentRepo.findAll());
        model.addAttribute("auth", worker);
        return "addWorker";
    }

    @PostMapping("/addworker")
    public String getAdd(/*Worker worker*/
            @RequestParam String name,
            @RequestParam String lastname,
            @RequestParam String password,
            @RequestParam String post,
            @RequestParam Role roles,
            @RequestParam String departments)
    {
        System.out.println(departments);
        Worker worker = new Worker(name, lastname, password, post, Collections.singleton(roles), departmentRepo.findByDepartment(departments));
        System.out.println(worker.toString());
        workerRepo.save(worker);
        return "redirect:/main";
    }
}
