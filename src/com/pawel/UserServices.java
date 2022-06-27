package com.pawel;

import java.util.Scanner;

public class UserServices {
    private static final UserServices userServices = new UserServices();
    private UserServices() { }
    public static UserServices getInstance(){
        return userServices;
    }

    private final UserRepository userRepository = UserRepository.getInstance();

    public void userRegister()
    {
        User newUser = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj login");
        newUser.setLogin(scanner.next());
        System.out.println("podaj haslo");
        newUser.setPassword(scanner.next());
        if (!UserValidation.getInstance().checkRegister(newUser).isEmpty()){
            for (EnumValidation enums : UserValidation.getInstance().checkRegister(newUser))
            {
                System.out.println(enums.statement);
            }
        } else {
            userRepository.addUser(newUser);
        }
        Main.menu();
    }

    public void userLogin()
    {
        User checkUser = new User();
        Scanner scanner = new Scanner(System.in);
        System.out.println("podaj login");
        checkUser.setLogin(scanner.next());
        System.out.println("podaj haslo");
        checkUser.setPassword(scanner.next());
        if (!UserValidation.getInstance().checkLogin(checkUser).isEmpty()) {
            for (EnumValidation enums : UserValidation.getInstance().checkLogin(checkUser)) {
                System.out.println(enums.statement);
            }
        } else {
            User activeUser = userRepository.getUserByUsername(checkUser);
            UserLogged.getInstance().setActiveUser(activeUser);
        }
        Main.menu();
    }
}