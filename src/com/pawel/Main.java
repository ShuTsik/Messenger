package com.pawel;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    static void menu() {
        System.out.println("\n#####################################\nMain Menu\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("User interface:\n1.Login\n2.Register\n3.Wyłącz aplikacje");
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
                UserServices.getInstance().userLogin();
                break;
            case 2:
                UserServices.getInstance().userRegister();
                break;
            case 3:
                break;
            default:
                menu();
                break;
        }
    }

    /*
    todo
    LOGOWANIE:
    - dodać klasę singleton ... która posiada referencję do obiektu aktualnie zalogowanego użytkownika

    repozytorium z obiektami wiadomości

    uporządkowanie konsoli

    błędy walidacji określone listą enumów
     */
}
