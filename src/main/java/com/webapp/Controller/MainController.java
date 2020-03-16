package com.webapp.Controller;

import com.webapp.entity.Department;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repository.WorkersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;


@Controller
public class MainController
{
    @Autowired
    WorkersRepo workersRepo;

    @GetMapping("/main")
    public String getAdd(Model model)
    {
        model.addAttribute("Role", Role.values());
        model.addAttribute("Department", Department.values());


        model.addAttribute("gen_dir", workersRepo.findAllByRoles(Role.GEN_DIRECT));

        model.addAttribute("dir_it", workersRepo.findAllByRoles(Role.DIRECT_IT));
        model.addAttribute("dir_fin", workersRepo.findAllByRoles(Role.DIRECT_FIN));
        model.addAttribute("dir_per", workersRepo.findAllByRoles(Role.DIRECT_PERS));

        model.addAttribute("lead_it", workersRepo.findAllByRoles(Role.LEAD_IT));
        model.addAttribute("lead_fin", workersRepo.findAllByRoles(Role.LEAD_FIN));
        model.addAttribute( "lead_pers", workersRepo.findAllByRoles(Role.LEAD_PERS));


        ArrayList<Worker> workers = workersRepo.findAllByRoles(Role.FRONT);
        workers.addAll(workersRepo.findAllByRoles(Role.BACK));
        model.addAttribute("worker_it", workers);




        return "index";
    }
}
