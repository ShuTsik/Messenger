package com.pawel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MessageServices {
    private static final MessageServices instance = new MessageServices();

    private MessageServices() {
    }

    ;

    public static MessageServices getInstance() {
        return instance;
    }

    public void sendMessage() {
        Message message = new Message();
        int i = 1;
        System.out.println("do kogo chcesz wyslac wiadomosc?");
        for (User user : UserRepository.getInstance().getUserList()) {
            System.out.println(i + ". " + user.getLogin());
            i++;
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt() - 1;
        message.setAuthor(UserLogged.getInstance().getActiveUser());
        message.setContent(scanner.next());
        message.setDestination(UserRepository.getInstance().getUserList().get(choice));
        UserRepository.getInstance().getUserList().get(choice).addMessage(message);
        System.out.println(UserRepository.getInstance().getUserList().get(choice).getUserMessages().size());
    }

    public void showMessages() {
        List<Integer> pages = new ArrayList<>();
        int page = 0;
        System.out.println("Wiadomosci:");
        System.out.println("----------------------------------------");
        for(int i = 0; i < UserLogged.getInstance().getActiveUser().getUserMessages().size(); i++) {
            if(i % 5 == 0) {
                page++;
                pages.add(page);
            }
        }
        System.out.println(Arrays.toString(pages.toArray()));

        for (Message message : UserLogged.getInstance().getActiveUser().getUserMessages()) {

            System.out.println(
                    "Wiadomosc od: " + message.getAuthor().getLogin() +
                            "\nTresc: " + message.getContent());
            System.out.println("----------------------------------------");
        }
        UserMessageView.getInstance().showMenu();
    }
}
