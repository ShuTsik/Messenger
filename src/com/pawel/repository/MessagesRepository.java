package com.pawel.repository;

import com.pawel.model.Message;

import java.util.ArrayList;
import java.util.List;

public class MessagesRepository {
    private static final MessagesRepository instance = new MessagesRepository();
    private MessagesRepository() { };
    public static MessagesRepository getInstance(){
        return instance;
    }
    private final List<Message> messages = new ArrayList<>();
    public void addMessage(Message message) {
        messages.add(message);
    }
    public List<Message> showMessages() {

        return messages;
    }

    public List<Message> getMessages() {
        return messages;
    }
}
