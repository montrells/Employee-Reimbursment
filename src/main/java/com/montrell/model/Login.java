package com.montrell.model;

import java.io.Serializable;

public class Login implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1 ;
    private String username;
    private String password;
    private int user_roll_id = 1;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public int getUser_roll_id(){
        return user_roll_id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }
}
