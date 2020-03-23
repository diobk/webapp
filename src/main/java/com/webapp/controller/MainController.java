package com.webapp.controller;

import com.webapp.entity.Department;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repo.WorkerRepo;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class MainController
{
    @Autowired
    WorkerRepo workerRepo;

    @GetMapping("/main")
    public String getMain(@AuthenticationPrincipal Worker worker, Model model)
    {
        model.addAttribute("gen_dir", workerRepo.findAllByRoles(Role.GEN_DIR).get(0));

        model.addAttribute("Dir", workerRepo.findAllByRoles(Role.DIR));

        model.addAttribute("Lead", workerRepo.findAllByRoles(Role.LEAD));

        model.addAttribute("Worker", workerRepo.findAllByRoles(Role.WORKER));

        model.addAttribute("AllWorker", workerRepo.findAll());

        model.addAttribute("authWorker", worker);

        return "main";
    }

    @GetMapping("/hello")
    public String  getHello(@AuthenticationPrincipal Worker worker, Model model)
    {
        model.addAttribute("worker", worker);
        return "hello";
    }

    @GetMapping("/index")
    public String getIndex(Model model, @AuthenticationPrincipal Worker worker)
    {

        return "hello";
    }
}
