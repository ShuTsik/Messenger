package com.pawel.repository;

import com.pawel.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static final UserRepository instance = new UserRepository();
    private UserRepository() {}
    public static UserRepository getInstance() {
        return instance;
    }

    private final List<User> userList = new ArrayList<>();
    public void addUser(User checkUser) {
        userList.add(checkUser);
    }

    public User getUserByUsername(String checkUser) {
        for (User user : userList) {
            if(user.getLogin().equals(checkUser)) {
                return user;
            }
        }
        return null;
    }


    public List<User> getUserList() {
        return userList;
    }

}
