package com.webapp.service;


import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repository.WorkersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerService
{
    @Autowired
    WorkersRepo workersRepo;

    public ArrayList<Worker> findAllByRoles (Role role) { return workersRepo.findAllByRoles(role); }

    public ArrayList<Worker> findAll() { return (ArrayList<Worker>) workersRepo.findAll(); }

    public void save(Worker worker) { workersRepo.save(worker); }

    public Worker findByName(String name)
    {
        System.out.println(name);
        return workersRepo.findByName(name);
    }
}
