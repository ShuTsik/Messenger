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
    public void addUser(User checkUser) {
        if(!UserValidation.getInstance().checkRegister(checkUser).isEmpty()){
            for(EnumValidation enums : UserValidation.getInstance().checkRegister(checkUser))
            {
                System.out.println(enums.statement);
            }
        }else{
        userList.add(checkUser);
        System.out.println(userList.size());
        }
    }

    public String userLogin(User checkUser) {
        if (!UserValidation.getInstance().checkLogin(checkUser).isEmpty()) {
            for (EnumValidation enums : UserValidation.getInstance().checkLogin(checkUser)) {
                System.out.println(enums.statement);
            }
        }else{
            UserLogged.getInstance().setActiveUser(checkUser);
        }
        return checkUser.getLogin();
    }



    public List<User> getUserList() {
        return userList;
    }

}
