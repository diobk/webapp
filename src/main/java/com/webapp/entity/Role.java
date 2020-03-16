package com.webapp.entity;


import javax.persistence.Entity;

public enum Role
{
    GEN_DIRECT,


    DIRECT_IT,
        LEAD_IT,
            FRONT,
            BACK,

    DIRECT_FIN,
        LEAD_FIN,
            ECO,

    DIRECT_PERS,
        LEAD_PERS,
            CPEC_ADAPT
}
