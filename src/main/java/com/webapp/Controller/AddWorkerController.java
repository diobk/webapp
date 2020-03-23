package com.webapp.controller;

import com.webapp.entity.Department;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repo.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddWorkerController
{
    @Autowired
    WorkerRepo workerRepo;

    @GetMapping("/addworker")
    public String getAdd(Model model)
    {
        model.addAttribute("role", Role.values());
        model.addAttribute("department", Department.values());
        return "addworker";
    }

    @PostMapping("/addworker")
    public String  getAdd(Worker worker)
    {
        System.out.println(worker.toString());
        workerRepo.save(worker);
        return "redirect:/main";
    }
}
