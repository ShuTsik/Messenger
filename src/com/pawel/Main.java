package com.pawel;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        System.out.println("\n######################################\nmain menu\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("User interface:\n1.Login\n2.Register");
        String choiceS = scanner.next();
        int choice = 0;
        try {
            choice = Integer.parseInt(choiceS);
        } catch (Exception e) {
            System.out.println("Podano nieprawidłową wartość");
        }
        switch(choice)
        {
            case 1:
                System.out.println("1");
                break;
            case 2:
                UserServices.getInstance().userRegister();
                break;
            default:
                menu();
                break;
        }
    }

    /*
    todo
    - dodać możliwość wyłaczenia aplikacji
    LOGOWANIE:
    - dodać klasę singleton ... która posiada referencję do obiektu aktualnie zalogowanego użytkownika

    repozytorium z obiektami wiadomości

    uporządkowanie konsoli

    błędy walidacji określone listą enumów
     */
}
