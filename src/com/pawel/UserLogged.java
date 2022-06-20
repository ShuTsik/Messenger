package com.pawel;

public class UserLogged {
    private static final UserLogged userLogged = new UserLogged();
    private UserLogged() { }
    public static UserLogged getInstance(){
        return userLogged;
    }

    public void setActiveUser(User user) {
        System.out.println(user.getLogin());
    }
}


