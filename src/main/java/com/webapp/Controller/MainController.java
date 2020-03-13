package com.webapp.Controller;

import com.webapp.entity.Department;
import com.webapp.entity.Position;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repository.WorkersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


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
        model.addAttribute("Position", Position.values());

        model.addAttribute("gen_dir", workersRepo.findAllByRoles(Role.GEN_DIRECT));


        model.addAttribute("dir_it", workersRepo.findAllByRoles(Role.DIRECT_IT));
        model.addAttribute("dir_fin", workersRepo.findAllByRoles(Role.DIRECT_FIN));
        model.addAttribute("dir_pers", Role.DIRECT_PERS);


        model.addAttribute("lead_front", Role.LEAD_FRONT);
        model.addAttribute("lead_back", Role.LEAD_BACK);
        model.addAttribute("lead_bug", Role.LEAD_BUG);
        model.addAttribute("lead_adapt", Role.LEAD_ADAPT);


//        model.addAttribute("dir", addList(workersRepo.findAllByRoles(Role.DIRECT_IT),
//                workersRepo.findAllByRoles(Role.DIRECT_PERS),
//                workersRepo.findAllByRoles(Role.DIRECT_FIN)));


        return "index";
    }

    private ArrayList<Worker> addList(ArrayList<Worker> list1, ArrayList<Worker> list2, ArrayList<Worker> list3)
    {
        ArrayList<Worker> list = new ArrayList<>();

        if (!list1.isEmpty())
            list.addAll(list1);
        if (!list2.isEmpty())
            list.addAll(list2);
        if (!list3.isEmpty())
            list.addAll(list3);
        return list;
    }
}
