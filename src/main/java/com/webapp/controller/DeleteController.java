package com.webapp.controller;


import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repo.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DeleteController
{
    @Autowired
    WorkerRepo workerRepo;

    @GetMapping("/delworker/{id}")
    public String deleteWorker(@PathVariable("id") Long id, @AuthenticationPrincipal Worker worker)
    {
        System.out.println(workerRepo.findById(id).get().toString());
        workerRepo.delete(workerRepo.findById(id).get());

        return "redirect:/main";
    }
}
