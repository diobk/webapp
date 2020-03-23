package com.webapp.sql;


import com.webapp.entity.Department;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repo.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;

@Controller
public class AddController
{
    @Autowired
    WorkerRepo workerRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/add")
    public void getAdd()
    {
        workerRepo.save(new Worker("Имя1", "Фамилия", passwordEncoder.encode("password"), "Генеральный директор", Collections.singleton(Role.GEN_DIR), Collections.singleton(Department.GEN_DEP)));


        workerRepo.save(new Worker("Имя2", "Фамилия", passwordEncoder.encode("password"), "IT директор", Collections.singleton(Role.DIR), Collections.singleton(Department.WEB_DEP)));
        workerRepo.save(new Worker("Имя3", "Фамилия", passwordEncoder.encode("password"), "Директор финансов", Collections.singleton(Role.DIR), Collections.singleton(Department.FINANCE_DEP)));
        workerRepo.save(new Worker("Имя4", "Фамилия", passwordEncoder.encode("password"), "Директора по персоналу", Collections.singleton(Role.DIR), Collections.singleton(Department.PERSONAL_DEP)));


        workerRepo.save(new Worker("Имя5", "Фамилия", passwordEncoder.encode("password"), "Руководитель IT отдела", Collections.singleton(Role.LEAD), Collections.singleton(Department.WEB_DEP)));
        workerRepo.save(new Worker("Имя6", "Фамилия", passwordEncoder.encode("password"), "Руководитель отдела финансов", Collections.singleton(Role.LEAD), Collections.singleton(Department.FINANCE_DEP)));
        workerRepo.save(new Worker("Имя7", "Фамилия", passwordEncoder.encode("password"), "Руководитель отдела по персоналу", Collections.singleton(Role.LEAD), Collections.singleton(Department.PERSONAL_DEP)));

        workerRepo.save(new Worker("Имя8", "Фамилия", passwordEncoder.encode("password"), "Frontend разработчик", Collections.singleton(Role.WORKER), Collections.singleton(Department.WEB_DEP)));
        workerRepo.save(new Worker("Имя9", "Фамилия", passwordEncoder.encode("password"), "Backend разработчик", Collections.singleton(Role.WORKER), Collections.singleton(Department.WEB_DEP)));
        workerRepo.save(new Worker("Имя10", "Фамилия", passwordEncoder.encode("password"), "Экономист", Collections.singleton(Role.WORKER), Collections.singleton(Department.FINANCE_DEP)));
        workerRepo.save(new Worker("Имя11", "Фамилия", passwordEncoder.encode("password"), "Специалис по адаптации", Collections.singleton(Role.WORKER), Collections.singleton(Department.PERSONAL_DEP)));
        workerRepo.save(new Worker("user", "Фамилия", passwordEncoder.encode("password"), "Специалис по адаптации", Collections.singleton(Role.WORKER), Collections.singleton(Department.PERSONAL_DEP)));
        workerRepo.save(new Worker("q", "Фамилия", passwordEncoder.encode("q"), "Специалис по адаптации", Collections.singleton(Role.WORKER), Collections.singleton(Department.PERSONAL_DEP)));
    }

    @GetMapping("/del")
    public void getDell()
    {
        workerRepo.deleteAll();
    }
}
