package com.pawel;

public class UserLogged {
    private static final UserLogged instance = new UserLogged();
    private UserLogged() { }
    public static UserLogged getInstance(){
        return instance;
    }

    public void setActiveUser(User user) {
        System.out.println("Pomyslnie zalogowano uzytkownika: " + user.getLogin());
    }
}


