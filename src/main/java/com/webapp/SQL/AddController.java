package com.webapp.SQL;


import com.webapp.entity.Department;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;

@Controller
public class AddController
{
    @Autowired
    WorkerService workerService;

    @GetMapping("/add")
    void addWorker()
    {
        workerService.save(new Worker("Имя1", "Фамилия", "password", "Генеральный директор", Collections.singleton(Role.GEN_DIR), Collections.singleton(Department.GEN_DEP)));


        workerService.save(new Worker("Имя2", "Фамилия", "password", "IT директор", Collections.singleton(Role.DIR), Collections.singleton(Department.WEB_DEP)));
        workerService.save(new Worker("Имя3", "Фамилия", "password", "Директор финансов", Collections.singleton(Role.DIR), Collections.singleton(Department.FINANCE_DEP)));
        workerService.save(new Worker("Имя4", "Фамилия", "password", "Директора по персоналу", Collections.singleton(Role.DIR), Collections.singleton(Department.PERSONAL_DEP)));


        workerService.save(new Worker("Имя5", "Фамилия", "password", "Руководитель IT отдела", Collections.singleton(Role.LEAD), Collections.singleton(Department.WEB_DEP)));
        workerService.save(new Worker("Имя6", "Фамилия", "password", "Руководитель отдела финансов", Collections.singleton(Role.LEAD), Collections.singleton(Department.FINANCE_DEP)));
        workerService.save(new Worker("Имя7", "Фамилия", "password", "Руководитель отдела по персоналу", Collections.singleton(Role.LEAD), Collections.singleton(Department.PERSONAL_DEP)));

        workerService.save(new Worker("Имя8", "Фамилия", "password", "Frontend разработчик", Collections.singleton(Role.WORKER), Collections.singleton(Department.WEB_DEP)));
        workerService.save(new Worker("Имя9", "Фамилия", "password", "Backend разработчик", Collections.singleton(Role.WORKER), Collections.singleton(Department.WEB_DEP)));
        workerService.save(new Worker("Имя10", "Фамилия", "password", "Экономист", Collections.singleton(Role.WORKER), Collections.singleton(Department.FINANCE_DEP)));
        workerService.save(new Worker("Имя11", "Фамилия", "password", "Специалис по адаптации", Collections.singleton(Role.WORKER), Collections.singleton(Department.PERSONAL_DEP)));
        workerService.save(new Worker("user", "Фамилия", "pass", "Специалис по адаптации", Collections.singleton(Role.WORKER), Collections.singleton(Department.PERSONAL_DEP)));
        workerService.save(new Worker("q", "Фамилия", "q", "Специалис по адаптации", Collections.singleton(Role.WORKER), Collections.singleton(Department.PERSONAL_DEP)));
    }
}












