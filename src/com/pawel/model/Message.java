package com.pawel.model;

import com.pawel.model.User;

public class Message {
    private int id;
    private User author;
    private User destination;
    private String content;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getDestination() {
        return destination;
    }

    public void setDestination(User destination) {
        this.destination = destination;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
