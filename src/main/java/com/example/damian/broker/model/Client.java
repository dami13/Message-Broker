package com.example.damian.broker.model;

public class Client {

    private String name;
    private String url;
    private String messageType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String subscribedMessageType) {
        this.messageType = subscribedMessageType;
    }
}
