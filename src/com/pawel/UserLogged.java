package com.pawel;

import com.pawel.model.User;

public class UserLogged {
    private static final UserLogged instance = new UserLogged();
    private UserLogged() { }
    public static UserLogged getInstance(){
        return instance;
    }
   private User activeUser;
    public void setActiveUser(User user) {
        activeUser = user;
    }

    public User getActiveUser() {
        return activeUser;
    }
}


