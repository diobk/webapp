package com.webapp.entity;


import org.hibernate.annotations.Fetch;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
public class Worker implements UserDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String lastname;

    private String password;

    private String post;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "worker_role", joinColumns = @JoinColumn(name = "worker_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

//    @ElementCollection(targetClass = Department.class, fetch = FetchType.EAGER)
//    @CollectionTable(name = "worker_dep", joinColumns = @JoinColumn(name = "worker_id"))
//    @Enumerated(EnumType.STRING)
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Department> departments;

    public Worker() { }

    public Worker(String name, String lastname, String password, String post, Set<Role> roles, Set<Department> departments)
    {
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.post = post;
        this.roles = roles;
        this.departments = departments;
    }

    public Worker(long id, String name, String lastname, String password, String post, Set<Role> roles, Set<Department> departments)
    {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
        this.post = post;
        this.roles = roles;
        this.departments = departments;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
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

    @Override
    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPost()
    {
        return post;
    }

    public void setPost(String post)
    {
        this.post = post;
    }

    public Set<Role> getRoles()
    {
        return roles;
    }

    public void setRoles(Set<Role> roles)
    {
        this.roles = roles;
    }

    public String getDepartment()
    {
        return departments.iterator().next().getDepartment();
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
                ", password='" + password + '\'' +
                ", post='" + post + '\'' +
                ", roles=" + roles +
                ", departments=" + departments +
                '}';
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return getRoles();
    }

    @Override
    public String getUsername()
    {
        return getName();
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
