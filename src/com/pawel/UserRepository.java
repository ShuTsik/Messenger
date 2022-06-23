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
    public void addUser(User newUser) {

        if(!ServicesValidation.getInstance().checkRegister(newUser).isEmpty()){
            for(EnumValidation enums : ServicesValidation.getInstance().checkRegister(newUser))
            {
                System.out.println(enums.statement);
            }
        }
        userList.add(newUser);
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
                UserLogged.getInstance().setActiveUser(user);
                return true;
            }
        }
        return false;
    }

    public List<User> getUserList() {
        return userList;
    }

}
