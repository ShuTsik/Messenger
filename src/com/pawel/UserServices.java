package com.pawel;

import java.util.Scanner;

public class UserServices {
    private static UserServices userServices = new UserServices();
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
        boolean success = userRepository.addUser(newUser);
        if (!success) {
            System.out.println("Błąd rejestracji");
        }
        System.out.println(userRepository.getUserList().size());
        Main.menu();
    }
}