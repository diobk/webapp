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

        model.addAttribute("gen_dir", workersRepo.findAllByRoles(Role.GEN_DIRECT).get(0));

        model.addAttribute("dir_it", workersRepo.findAllByRoles(Role.DIRECT_IT));
        model.addAttribute("dir_fin", workersRepo.findAllByRoles(Role.DIRECT_FIN));
        model.addAttribute("dir_per", workersRepo.findAllByRoles(Role.DIRECT_PERS));

        model.addAttribute("lead_it", workersRepo.findAllByRoles(Role.LEAD_IT));
        model.addAttribute("lead_fin", workersRepo.findAllByRoles(Role.LEAD_FIN));
        model.addAttribute("lead_per", workersRepo.findAllByRoles(Role.LEAD_PERS));

        ArrayList itDep = workersRepo.findAllByRoles(Role.FRONT);
        itDep.addAll(workersRepo.findAllByRoles(Role.BACK));
        model.addAttribute("it_dep", itDep);
        model.addAttribute("fin_dep", workersRepo.findAllByRoles(Role.ECO));
        model.addAttribute("pers_dep", workersRepo.findAllByRoles(Role.CPEC_ADAPT));


        System.out.println(workersRepo.findAll().size());

        System.out.println(model.getAttribute("it_dep"));

        return "index";
    }
}
