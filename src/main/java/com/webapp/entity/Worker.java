package com.webapp.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
public class Worker
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String lastname;

    private String pass;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "worker_role", joinColumns = @JoinColumn(name = "worker_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "worker_department", joinColumns = @JoinColumn(name = "worker_id"))
    @Enumerated(EnumType.STRING)
    private Set<Department> departments;

    public Worker() { }

    public Worker(String name, String lastname, String pass, Set<Role>  role, Set<Department> departments)
    {
        this.name = name;
        this.lastname = lastname;
        this.pass = pass;
        this.roles = role;
        this.departments = departments;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }

    public String getPass()
    {
        return pass;
    }

    public void setPass(String pass)
    {
        this.pass = pass;
    }

    public Set<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }

    public Set<Department> getDepartments()
    {
        return departments;
    }

    public void setDepartments(Set<Department> departments)
    {
        this.departments = departments;
    }

    @Override
    public String toString()
    {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", pass='" + pass + '\'' +
                ", roles=" + roles +
                ", departments=" + departments +
                '}';
    }
}