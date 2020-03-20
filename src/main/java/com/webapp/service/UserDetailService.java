package com.webapp.service;

import com.webapp.entity.Role;
import com.webapp.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailService implements UserDetailsService
{
    @Autowired
    private WorkerService workerService;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException
    {
        System.out.println(123);
        
        Worker worker = workerService.findByName(name);

        if (worker == null)
            return new User(worker.getName(), worker.getPassword(), getAuthorities(worker));

        return new User(worker.getName(), worker.getPass(), getAuthorities(worker));
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
