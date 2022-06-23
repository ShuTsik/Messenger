package com.pawel;

import java.util.ArrayList;
import java.util.List;

public class ServicesValidation {
    private static final ServicesValidation instance = new ServicesValidation();
    private ServicesValidation() { };
    public static ServicesValidation getInstance(){
        return instance;
    }
    public List<EnumValidation> checkRegister(User user){
        List<EnumValidation> errors = new ArrayList<>();
        if (user == null || user.getLogin() == null || user.getLogin().trim().length() == 1){
            errors.add(EnumValidation.USERNAMETOOSHORT);
        }
        for(User test : UserRepository.getInstance().getUserList())
        {
            if(test.getLogin().equals(user.getLogin()))
            {
                errors.add(EnumValidation.USERNAMENOTUNIQUE);
            }
        }
    return errors;
    }
}
