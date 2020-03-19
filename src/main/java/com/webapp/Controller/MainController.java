package com.webapp.Controller;

import com.webapp.entity.Department;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repository.WorkersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


@Controller
public class MainController
{
    @Autowired
    WorkersRepo workersRepo;

    @GetMapping("/main")
    public String getMain(Model model)
    {

        model.addAttribute("gen_dir", workersRepo.findAllByRoles(Role.GEN_DIR).get(0));

        model.addAttribute("Dir", workersRepo.findAllByRoles(Role.DIR));

        model.addAttribute("Lead", workersRepo.findAllByRoles(Role.LEAD));

        model.addAttribute("Worker", workersRepo.findAllByRoles(Role.WORKER));

        model.addAttribute("AllWorker", workersRepo.findAll());



        return "index";
    }
}
