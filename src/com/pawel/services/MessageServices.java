package com.pawel.services;

import com.pawel.PaginateList;
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

    public static MessageServices getInstance() {
        return instance;
    }

    private static final int paginatedPage = 5;
    private List<Message> userMessages = UserLogged.getInstance().getActiveUser().getUserMessages();
    public void sendMessage() {
        List<User> users = UserRepository.getInstance().getUserList();
        Message message = new Message();
        System.out.println("do kogo chcesz wyslac wiadomosc?");
        for (User user : PaginateList.paginateList(users,paginatedPage)) {
            System.out.println(user.getId() + ". " + user.getLogin());
        }
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        message.setAuthor(UserLogged.getInstance().getActiveUser());
        message.setId(UserRepository.getInstance().getUserList().get(choice - 1).getUserMessages().size() + 1);
        System.out.println("Tresc wiadomosci: ");
        message.setContent(scanner.nextLine());

        try {
            UserRepository.getInstance().getUserList().get(choice - 1).addMessage(message);
        } catch (Exception e) {
            System.out.println("taki uzytkownik nie istnieje");
            return;
        }

    }



    public void showMessages() {
        System.out.println("Wiadomosci:");
        System.out.println("----------------------------------------");

        try {
            for (Message message : PaginateList.paginateList(userMessages,paginatedPage)) {

                System.out.println(
                        "Wiadomosc od: " + message.getAuthor().getLogin() +
                                "\nTresc: " + message.getContent());
                System.out.println("----------------------------------------");
            }
            UserMessageView.getInstance().showMenu();
        } catch (Exception e) {
            System.out.println("Podano zla wartosc");
        }
        }

    public void deleteMessage() {
        System.out.println("Wybierz wiadomosc, ktora chcesz usunac");
        try {
            for(Message message : PaginateList.paginateList(userMessages,paginatedPage)) {
                System.out.println(
                        "[" + message.getId() + "]" +
                                "Wiadomosc od: " + message.getAuthor().getLogin() +
                                "\nTresc: " + message.getContent());
                System.out.println("----------------------------------------");
            }
            } catch (Exception e){
                System.out.println("Podano zla wartosc");
            }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ktora wiadomosc chcesz usunac?");
        try {
            userMessages.remove(scanner.nextInt() - 1);
        } catch (Exception IndexOutOfBoundsException) {
            System.out.println("Wybrany element nie istnieje");
        }

    }
}
