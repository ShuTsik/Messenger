package com.pawel.services;

import com.pawel.UserLogged;
import com.pawel.views.UserMessageView;
import com.pawel.repository.UserRepository;
import com.pawel.model.Message;
import com.pawel.model.User;

import java.util.*;

public class MessageServices {
    private static final MessageServices instance = new MessageServices();

    private MessageServices() {
    }

    ;

    public static MessageServices getInstance() {
        return instance;
    }

    private static final int paginatedPage = 5;

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
        scanner.nextLine();
        message.setAuthor(UserLogged.getInstance().getActiveUser());
        System.out.println("Tresc wiadomosci: ");
        message.setContent(scanner.nextLine());

        try {
            message.setDestination(UserRepository.getInstance().getUserList().get(choice));
            UserRepository.getInstance().getUserList().get(choice).addMessage(message);
        } catch (Exception e) {
            System.out.println("taki uzytkownik nie istnieje");
            return;
        }

    }



    public void showMessages() {
        int pages = 0;
        int activePage = 1;
        List<Message> userMessages = UserLogged.getInstance().getActiveUser().getUserMessages();
        for(int i = 0; i <= userMessages.size(); i++) {
            if(i % 5 == 0) {
                pages++;
            }
        }
        System.out.println("Wybierz strone z wiadomosciami: ");
        System.out.println(activePage + "/" + pages);
        Scanner scanner = new Scanner(System.in);
        activePage = scanner.nextInt();
        System.out.println("Wiadomosci:");
        System.out.println("----------------------------------------");

        if(activePage <=0) {
            System.out.println("Taka strona nie istnieje");
            return;
        }
        int fromIndex = (activePage - 1) * paginatedPage;
        if(userMessages == null || userMessages.size() <= fromIndex) {
            System.out.println("Brak wiadomosci");
            return;
        }

        for (Message message : userMessages.subList(fromIndex, Math.min(fromIndex + paginatedPage, userMessages.size()))) {

            System.out.println(
                    "Wiadomosc od: " + message.getAuthor().getLogin() +
                            "\nTresc: " + message.getContent());
            System.out.println("----------------------------------------");
        }
        System.out.println(activePage + "/" + pages);
        UserMessageView.getInstance().showMenu();
    }
}
