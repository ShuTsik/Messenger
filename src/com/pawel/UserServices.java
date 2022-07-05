package com.pawel;

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

        if(userRepository.getUserByUsername(checkUser) == null) {
            System.out.println("Uzytkownik o podanym loginie nie istnieje");
            return;
        }

        UserLogged.getInstance().setActiveUser(UserRepository.getInstance().getUserByUsername(checkUser));
        LoggedUserMenuView.getInstance().showMenu();
    }
}