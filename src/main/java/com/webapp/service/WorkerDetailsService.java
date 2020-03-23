package com.webapp.service;

import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import com.webapp.repo.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
public class WorkerDetailsService implements UserDetailsService
{
    @Autowired
    WorkerRepo workerRepo;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException
    {
        System.out.println(123);
        Worker worker = workerRepo.findByName(name);

        if (worker == null)
            throw new UsernameNotFoundException("not found user with " + name);

        return worker;
//        return new User(worker.getName(), worker.getPassword(), getAuthorities(worker));
    }

    private Set<GrantedAuthority> getAuthorities(Worker user)
    {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for (Role role : user.getRoles())
        {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.toString());
            authorities.add(grantedAuthority);
        }
        System.out.println("user auth " + user.getName());
        return authorities;
    }
}
