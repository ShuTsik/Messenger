package com.pawel;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final UserRepository instance = new UserRepository();
    private UserRepository() {}
    public static UserRepository getInstance() {
        return instance;
    }

    private final List<User> userList = new ArrayList<>();

    public boolean addUser(User newUser) {
        if (newUser == null ||
                newUser.getLogin() == null || newUser.getLogin().trim().length() == 0 ||
                newUser.getPassword() == null|| newUser.getPassword().trim().length() == 0) {
            return false;
        }
        for (User user : userList) {
            if (newUser.getLogin().equals(user.getLogin())) {
                return false;
            }
        }
        userList.add(newUser);
        return true;
    }

    public boolean userLogin(User checkUser)
    {
        if(checkUser == null ||
                checkUser.getLogin() == null || checkUser.getLogin().trim().length() == 0 ||
                checkUser.getPassword() == null || checkUser.getPassword().trim().length() == 0){
            return false;
        }
        for (User user : userList)
        {
            if(checkUser.getLogin().equals(user.getLogin()) && checkUser.getPassword().equals(user.getPassword()))
            {
                System.out.println("Pomyślnie zalogowano");
                return true;
            }
        }
        return false;
    }

    public List<User> getUserList() {
        return userList;
    }

}
