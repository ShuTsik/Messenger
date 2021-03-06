package com.pawel.validation;

import com.pawel.model.User;
import com.pawel.repository.UserRepository;

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
            errors.add(EnumValidation.FIELD_IS_EMPTY);
        }
        for(User user : UserRepository.getInstance().getUserList())
        {
            if(user.getLogin().equals(checkUser.getLogin()))
            {
                errors.add(EnumValidation.USERNAME_NOT_UNIQUE);
            }
        }
        if (checkUser == null || checkUser.getPassword() == null || checkUser.getPassword().trim().length() == 0){
            errors.add(EnumValidation.FIELD_IS_EMPTY);
        }
    return errors;
    }
    /*
    public List<EnumValidation> checkLogin(User checkUser) {
        List<EnumValidation> errors = new ArrayList<>();
        if (checkUser == null ||
                checkUser.getLogin() == null || checkUser.getLogin().trim().length() == 0 ||
                checkUser.getPassword() == null || checkUser.getPassword().trim().length() == 0) {
            errors.add(EnumValidation.FIELD_IS_EMPTY);
        }
        for(User user : UserRepository.getInstance().getUserList())
        {
            if(user.getLogin().equals(checkUser.getLogin()) && user.getPassword().equals(checkUser.getPassword()))
            {
                return new ArrayList<>();
            }
        }
        errors.add(EnumValidation.WRONG_IDENTITIES);
        return errors;
    }

     */
}
