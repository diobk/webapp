package com.webapp.repo;

import com.webapp.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long>
{
    Set<Department> findByDepartment(String department);
    Department findDepartmentByDepartment(String department);
}
