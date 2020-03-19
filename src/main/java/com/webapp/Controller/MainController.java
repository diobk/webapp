package com.webapp.Controller;

import com.webapp.entity.Role;
import com.webapp.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.model.IModel;


@Controller
public class MainController
{
    @Autowired
    WorkerService workerService;

    @GetMapping("/main")
    public String getMain(Model model)
    {

        model.addAttribute("gen_dir", workerService.findAllByRoles(Role.GEN_DIR).get(0));

        model.addAttribute("Dir", workerService.findAllByRoles(Role.DIR));

        model.addAttribute("Lead", workerService.findAllByRoles(Role.LEAD));

        model.addAttribute("Worker", workerService.findAllByRoles(Role.WORKER));

        model.addAttribute("AllWorker", workerService.findAll());

        System.out.println(workerService.findByName("user"));



        return "index";
    }

    @GetMapping("/home")
    public String getHome(Model model)
    {
        User user = (User) SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("user", user);
        return "home";
    }
}
