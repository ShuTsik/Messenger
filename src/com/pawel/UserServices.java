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
        boolean success = userRepository.userLogin(checkUser);
        if(!success) {
            System.out.println("Podany login lub hasło są nieprawidlowe");
        }
        Main.menu();
    }
}