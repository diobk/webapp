package com.webapp.controller;


import com.webapp.entity.Department;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repo.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Controller
public class UpdateController
{
    @Autowired
    WorkerRepo workerRepo;

    @GetMapping("/update/{id}")
    public String getUpdate(@AuthenticationPrincipal Worker worker,
                            @PathVariable(name = "id") Long id, Model model)
    {
        model.addAttribute("worker", workerRepo.findById(id).get());
        return "update";
    }

    @PostMapping("/update")
    public String getUpdate(@RequestParam(name = "id") Long id,
                            @RequestParam(name = "name") String name,
                            @RequestParam(name = "lastname") String lastname,
                            @RequestParam(name = "password") String password,
                            @RequestParam(name = "post") String post,
                            @AuthenticationPrincipal Worker worker)
    {
        Worker worker1 = new Worker(id, name, lastname, password, post, workerRepo.findById(id).get().getRoles(), workerRepo.findById(id).get().getDepartments());
        System.out.println(workerRepo.findById(worker1.getId()).get().toString());
        System.out.println(worker1.toString());
        workerRepo.save(worker1);
        return "redirect:/main";
    }
}
