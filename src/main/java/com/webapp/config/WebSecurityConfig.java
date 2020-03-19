package com.webapp.config;

import com.webapp.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.test.web.reactive.server.XpathAssertions;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    @Qualifier("dataSource")
    private DataSource datasource;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                    .antMatchers( "/main", "/registration").permitAll()
                    .antMatchers("/add", "/new", "/static/**", "/addWorker", "/delworker/**").permitAll()
                    .antMatchers("/home").permitAll()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .successForwardUrl("/main")
                    .usernameParameter("username")
                    .passwordParameter("password")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(new UserDetailService());
    }



    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }

//    @SuppressWarnings("deprecation")
//    @Bean
//    public  NoOpPasswordEncoder noOpPasswordEncoder()
//    {
//        return (NoOpPasswordEncoder) noOpPasswordEncoder().getInstance();
//    }

    //    @Autowired
//    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth.jdbcAuthentication()
//                .dataSource(datasource)
//                .passwordEncoder(NoOpPasswordEncoder.getInstance())
//                .usersByUsernameQuery("select name, pass from worker where name = ?")
//                .groupAuthoritiesByUsername("select name, pass from worker where name = ?, pass = ?");
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth.jdbcAuthentication()
//                .dataSource(datasource)
//            .passwordEncoder(NoOpPasswordEncoder.getInstance())
//            .usersByUsernameQuery("select name, pass from worker where name = ?")
//            .groupAuthoritiesByUsername("select name, pass from worker where name = ?, pass = ?");
//    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService()
//    {
//        UserDetails user =
//                User.withDefaultPasswordEncoder()
//                        .username("user")
//                        .password("password")
//                        .roles("USER")
//                        .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
}
