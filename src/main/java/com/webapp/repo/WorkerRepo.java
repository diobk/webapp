package com.webapp.repo;

import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepo extends JpaRepository<Worker, Long>
{
    List<Worker> findAllByRoles(Role role);
    Worker findByName(String name);
}
