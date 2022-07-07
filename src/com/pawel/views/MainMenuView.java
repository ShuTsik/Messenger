package com.pawel.views;

import com.pawel.services.UserServices;

import java.util.Scanner;

public class MainMenuView extends AbstractView {
    private static final MainMenuView instance = new MainMenuView();
    private MainMenuView() { };
    public static MainMenuView getInstance() {
        return instance;
    }

    protected boolean show() {
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
        switch (choice) {
            case 1:
                UserServices.getInstance().userLogin();
                break;
            case 2:
                UserServices.getInstance().userRegister();
                break;
            case 3:
                return false;
            default:
                break;
        }
        return true;
    }

}
