package com.pawel;

public class UserLogged {
    boolean
    private static UserLogged userLogged = new UserLogged();
    private UserLogged() { }
    public static UserLogged getInstance(){
        return userLogged;
    }

    private final UserRepository userRepository = UserRepository.getInstance();

    public void setActiveUser(User user) {

    }
}


