package com.pawel;

import java.util.Scanner;

public class MainMenuInterface {
    private static final MainMenuInterface instance = new MainMenuInterface();
    private MainMenuInterface() { };
    public static MainMenuInterface getInstance() {
        return instance;
    }

    public void showMainMenu() {
        boolean activeMenu = true;
        while(activeMenu) {
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
                    activeMenu = false;
                    break;
                default:
                    break;
            }
        }
    }
}
