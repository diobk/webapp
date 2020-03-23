package com.webapp.entity;


import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;


public enum Role implements GrantedAuthority
{
    GEN_DIR,

    DIR,

    LEAD,

    WORKER;

    @Override
    public String getAuthority()
    {
        return name();
    }
}
