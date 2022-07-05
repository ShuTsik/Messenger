package com.pawel;

import java.util.Scanner;

public class UserMessageInterface {
    private static final UserMessageInterface instance = new UserMessageInterface();
    private UserMessageInterface() { };
    public static UserMessageInterface getInstance() {
        return instance;
    }

    public void showMessageMenu() {
        boolean activeMenu = true;
        while(activeMenu) {
            System.out.println("\n#####################################\nYour Messages\n");
            Scanner scanner = new Scanner(System.in);
            System.out.println("User interface:\n1.Usun wiadomosc\n2.Powrot do menu");
            String choiceS = scanner.next();
            int choice = 0;
            try {
                choice = Integer.parseInt(choiceS);
            } catch (Exception e) {
                System.out.println("Podano nieprawidłową wartość");
            }
            switch (choice) {
                case 1:
                    System.out.println("1"); //usuwanie wiadomosci
                    break;
                case 2:
                    activeMenu = false;
                    break;
                default:
                    break;
            }
        }
    }
}
