package com.webapp.service;

import com.sun.xml.bind.v2.model.core.EnumLeafInfo;
import com.webapp.entity.Department;
import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repository.WorkersRepo;
import com.webapp.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class UserDetailService implements UserDetailsService
{
    @Autowired
    WorkerService workerService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException
    {
        System.out.println(123123123);
        System.out.println(name);
//        System.out.println(workerService.findAll().size());
        try
        {
//            Worker worker = workerService.findByName(name);
//            if (worker == null)
//                return null;
//            return new User(worker.getName(), worker.getPass(), getAuthorities(worker));
            return new User("q", "q", getAuthorities(new Worker("q", "Фамилия", "q", "Специалис по адаптации", Collections.singleton(Role.WORKER), Collections.singleton(Department.PERSONAL_DEP))));
        }
        catch (UsernameNotFoundException ex)
        {
            System.out.println("User not found");
        }
        catch (NullPointerException ex)
        {
            ex.getMessage();
            ex.getCause();
            ex.printStackTrace();
        }
        return null;
    }

    private Set<GrantedAuthority> getAuthorities(Worker worker)
    {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for (Role role : worker.getRoles())
        {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.toString());
            authorities.add(grantedAuthority);
        }
        System.out.println("User auth" + authorities.toString());
        return authorities;
    }
}
