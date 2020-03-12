package com.webapp.Controller;

import com.webapp.entity.Department;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repository.WorkersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


@Controller
public class MainController
{
    @Autowired
    WorkersRepo workersRepo;

    @GetMapping("/")
    String getAdd(Model model)
    {
        workersRepo.save(new Worker("Имя", "Фамилия", "password", Collections.singleton(Role.DIRECT_IT), Collections.singleton(Department.WEB)));

        System.out.println(workersRepo.findAllByDepartments(Department.WEB).get(0).toString());
        return "home";
    }
}
