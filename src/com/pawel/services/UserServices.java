package com.pawel.services;

import com.pawel.validation.EnumValidation;
import com.pawel.UserLogged;
import com.pawel.model.User;
import com.pawel.repository.UserRepository;
import com.pawel.validation.UserValidation;
import com.pawel.views.LoggedUserMenuView;

import java.util.Scanner;

public class UserServices {
    private static final UserServices userServices = new UserServices();
    private UserServices() { }
    public static UserServices getInstance(){
        return userServices;
    }

    private final UserRepository userRepository = UserRepository.getInstance();
    private final UserValidation userValidation = UserValidation.getInstance();
    public void userRegister()
    {
        User newUser = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj login");
        newUser.setLogin(scanner.next());
        System.out.println("podaj haslo");
        newUser.setPassword(scanner.next());
        newUser.setId(userRepository.getUserList().size() + 1);
        if (!userValidation.checkRegister(newUser).isEmpty()) {
            for (EnumValidation enums : userValidation.checkRegister(newUser))
            {
                System.out.println(enums.statement);
            }
        } else {
            userRepository.addUser(newUser);
        }
    }

    public void userLogin()
    {
        User checkUser = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj login");
        checkUser.setLogin(scanner.next());
        System.out.println("podaj haslo");
        checkUser.setPassword(scanner.next());

        if(userRepository.getUserByUsername(checkUser.getLogin()) == null) {
            System.out.println("Uzytkownik o podanym loginie nie istnieje");
            return;
        }
        if(!userRepository.getUserByUsername(checkUser.getPassword()).getPassword().equals(checkUser.getPassword())) {
            System.out.println("nieprawidlowe dane logowania");
            return;
        }

        UserLogged.getInstance().setActiveUser(userRepository.getUserByUsername(checkUser.getLogin()));
        LoggedUserMenuView.getInstance().showMenu();
    }
}