package com.pawel;

public class UserLogged {
    private static UserLogged userLogged = new UserLogged();
    private UserLogged() { }
    public static UserLogged getInstance(){
        return userLogged;
    }

    public void setActiveUser(User user) {

    }
}


