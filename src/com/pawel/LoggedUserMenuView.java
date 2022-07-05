package com.pawel;

import java.util.Scanner;

public class LoggedUserMenuView extends AbstractView {
    private static final LoggedUserMenuView instance = new LoggedUserMenuView();
    private LoggedUserMenuView() { };
    public static LoggedUserMenuView getInstance() {
        return instance;
    }
    private final UserLogged userLogged = UserLogged.getInstance();

    protected boolean show() {
        System.out.println("\n#####################################\nLogged User Menu\n");
        System.out.println("Witaj: " + userLogged.getActiveUser().getLogin() + "!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("User interface:\n1.Sprawdz wiadomosci\n2.Wyslij wiadomosc\n3.Wyloguj");
        String choiceS = scanner.next();
        int choice = 0;
        try {
            choice = Integer.parseInt(choiceS);
        } catch (Exception e) {
            System.out.println("Podano nieprawidłową wartość");
        }
        switch (choice) {
            case 1:
                MessageServices.getInstance().showMessages();
                break;
            case 2:
                MessageServices.getInstance().sendMessage();
                break;
            case 3:
                return false;
            default:
                break;
        }
        return true;
    }
}
