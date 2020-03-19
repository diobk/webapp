package com.webapp.Controller;

import com.webapp.entity.Department;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repository.WorkersRepo;
import org.aspectj.weaver.ISourceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;


@Controller
public class WorkerController
{
    @Autowired
    private WorkersRepo workersRepo;

    @GetMapping("/addworker")
    public String addWorker(Model model)
    {
        model.addAttribute("role", Role.values());
        model.addAttribute("department", Department.values());
        return "addWorker";
    }

    @PostMapping("/addworker")
    public String add(Worker worker)
    {
        workersRepo.save(worker);
        return "redirect:/addWorker";
    }

    @GetMapping("/delworker/{id}")
    @RolesAllowed("")
    public String delWorker(@PathVariable("id") Long id)
    {
        System.out.println(workersRepo.findById(id));
        workersRepo.delete(workersRepo.findById(id).get());
        return "redirect:/main";
    }
}
