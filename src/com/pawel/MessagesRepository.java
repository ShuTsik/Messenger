package com.pawel;

import java.util.ArrayList;
import java.util.List;

public class MessagesRepository {
    private static final MessagesRepository instance = new MessagesRepository();
    private MessagesRepository() { };
    public static MessagesRepository getInstance(){
        return instance;
    }
    List<Message> messages = new ArrayList<>();
}
