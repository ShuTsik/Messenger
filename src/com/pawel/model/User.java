package com.pawel.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String login;
    private String password;
    private final List<Message> userMessages = new ArrayList<>();

    public User() {
    }

    User(String login, String password)
    {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Message> getUserMessages() {
        return userMessages;
    }
    public void addMessage(Message message){
        userMessages.add(message);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
