package com.pawel;

import java.util.ArrayList;
import java.util.List;

public class UserValidation {
    private static final UserValidation instance = new UserValidation();
    private UserValidation() { };
    public static UserValidation getInstance(){
        return instance;
    }
    public List<EnumValidation> checkRegister(User checkUser){
        List<EnumValidation> errors = new ArrayList<>();
        if (checkUser == null || checkUser.getLogin() == null || checkUser.getLogin().trim().length() == 0){
            errors.add(EnumValidation.FIELDISEMPTY);
        }
        for(User user : UserRepository.getInstance().getUserList())
        {
            if(user.getLogin().equals(checkUser.getLogin()))
            {
                errors.add(EnumValidation.USERNAMENOTUNIQUE);
            }
        }
        if (checkUser == null || checkUser.getPassword() == null || checkUser.getPassword().trim().length() == 0){
            errors.add(EnumValidation.FIELDISEMPTY);
        }
    return errors;
    }
    public List<EnumValidation> checkLogin(User checkUser) {
        List<EnumValidation> errors = new ArrayList<>();
        if (checkUser == null ||
                checkUser.getLogin() == null || checkUser.getLogin().trim().length() == 0 ||
                checkUser.getPassword() == null || checkUser.getPassword().trim().length() == 0) {
            errors.add(EnumValidation.FIELDISEMPTY);
        }
        for(User user : UserRepository.getInstance().getUserList())
        {
            if(!(user.getLogin().equals(checkUser.getLogin()) && user.getPassword().equals(checkUser.getPassword())))
            {
                errors.add(EnumValidation.WRONGIDENTITIES);
            }
        }
        return errors;
    }
}
