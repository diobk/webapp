package com.webapp.Controller;

import com.webapp.entity.Department;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repository.WorkersRepo;
import org.aspectj.weaver.ISourceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class NewController
{
    @Autowired
    private WorkersRepo workersRepo;

    @GetMapping("/addWorker")
    public String addWorker(Model model)
    {
        model.addAttribute("role", Role.values());
        model.addAttribute("department", Department.values());
        return "addWorker";
    }

    @PostMapping("/addWorker")
    public String add(Worker worker)
    {
//        Worker worker = new Worker(name, lastname, pass, post, Collections.singleton(roles), Collections.singleton(departments));
        System.out.println(worker.toString());
        System.out.println("Asdasafsfasf");
        return "redirect:/addWorker";
    }
}
