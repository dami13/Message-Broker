package com.example.damian.broker.service;

import com.example.damian.broker.model.Client;
import com.example.damian.broker.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChannelFacade {

    @Autowired
    private MessageChannelService messageChannelService;

    public void sendMessage(Message message) {
        messageChannelService.notifySubscribers(message);
    }

    public void addClient(Client client) {
        messageChannelService.subscribe(client);
    }
}
