package com.drtx.example.realchatapp.core.models;

public enum Role {
    USER,
    ADMIN;

    public String getRoleName(){
        return "ROLE_"+this.name();
    }
}
