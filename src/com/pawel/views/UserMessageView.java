package com.pawel.views;

import com.pawel.services.MessageServices;

import java.util.Scanner;

public class UserMessageView extends AbstractView {
    private static final UserMessageView instance = new UserMessageView();
    private UserMessageView() { };
    public static UserMessageView getInstance() {
        return instance;
    }

    protected boolean show() {
        System.out.println("\n#####################################\nTwoje Wiadomosci\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("User interface:\n1.Usun wiadomosc\n2.Wybierz strone do przejrzenia\n3.Powrot do menu");
        String choiceS = scanner.next();
        int choice = 0;
        try {
            choice = Integer.parseInt(choiceS);
        } catch (Exception e) {
            System.out.println("Podano nieprawidłową wartość");
        }
        switch (choice) {
            case 1:
                MessageServices.getInstance().deleteMessage();
                break;
            case 2:
                MessageServices.getInstance().showMessages();
            case 3:
                return false;
            default:
                break;
        }
        return true;
    }

}
