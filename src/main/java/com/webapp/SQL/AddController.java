package com.webapp.SQL;


import com.webapp.entity.Department;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repository.WorkersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;

@Controller
public class AddController
{
    @Autowired
    WorkersRepo workersRepo;

    @GetMapping("/add")
    void addWorker()
    {

        workersRepo.save(new Worker("Имя1", "Фамилия", "password", Collections.singleton(Role.GEN_DIRECT) , Collections.singleton(Department.GEN_DEP)));

        workersRepo.save(new Worker("Имя2", "Фамилия", "password", Collections.singleton(Role.DIRECT_IT) , Collections.singleton(Department.WEB_DEP)));
        workersRepo.save(new Worker("Имя3", "Фамилия", "password", Collections.singleton(Role.DIRECT_FIN) , Collections.singleton(Department.FINANCE_DEP)));
        workersRepo.save(new Worker("Имя4", "Фамилия", "password", Collections.singleton(Role.DIRECT_PERS) , Collections.singleton(Department.PESONAL_DEP)));


        workersRepo.save(new Worker("Имя5", "Фамилия", "password", Collections.singleton(Role.LEAD_IT) , Collections.singleton(Department.WEB_DEP)));
        workersRepo.save(new Worker("Имя6", "Фамилия", "password", Collections.singleton(Role.LEAD_FIN) , Collections.singleton(Department.FINANCE_DEP)));
        workersRepo.save(new Worker("Имя7", "Фамилия", "password", Collections.singleton(Role.LEAD_PERS) , Collections.singleton(Department.PESONAL_DEP)));


        workersRepo.save(new Worker("Имя8", "Фамилия", "password", Collections.singleton(Role.FRONT) , Collections.singleton(Department.WEB_DEP)));
        workersRepo.save(new Worker("Имя9", "Фамилия", "password", Collections.singleton(Role.BACK) , Collections.singleton(Department.WEB_DEP)));


        workersRepo.save(new Worker("Имя10", "Фамилия", "password", Collections.singleton(Role.ECO) , Collections.singleton(Department.FINANCE_DEP)));

        workersRepo.save(new Worker("Имя11", "Фамилия", "password", Collections.singleton(Role.CPEC_ADAPT) , Collections.singleton(Department.PESONAL_DEP)));
    }
}
