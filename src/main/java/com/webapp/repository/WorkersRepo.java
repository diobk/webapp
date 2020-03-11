package com.webapp.repository;

import com.webapp.entity.Department;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


//spring.jpa.hibernate.ddl-auto=create

@Repository
public interface WorkersRepo extends JpaRepository<Worker, Long>
{
    List<Worker> findAllByRoles(Role role);
    List<Worker> findAllByDepartments(Department department);
}
