package com.webapp.entity;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Department
{
//    GEN_DEP,
//
//    WEB_DEP,
//
//    FINANCE_DEP,
//
//    PERSONAL_DEP
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String department;

    public Department() { }

    public Department(String department) { this.department = department; }

    public Department(Long id, String department)
    {
        this.id = id;
        this.department = department;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDepartment()
    {
        return department;
    }

    public void setDepartment(String department)
    {
        this.department = department;
    }
}

