package com.example.damian.broker.service;

import com.example.damian.broker.model.Client;
import com.example.damian.broker.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class MessageChannelService {

    @Autowired
    private ClientRestService clientRestService;
    private List<Client> subscribers = Collections.synchronizedList(new ArrayList<>());

    public void subscribe(Client client) {
        subscribers.add(client);
    }

    public void unsubscribe(Client client) {
        subscribers.remove(client);
    }

    @Async
    public void notifySubscribers(Message message) {
        subscribers.stream()
                .filter(client -> client.getMessageType().equals(message.getMessageType()))
                .forEach(client -> clientRestService.sendNotification(client, message));
    }
}
