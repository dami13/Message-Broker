package com.example.damian.broker.provider;

import com.example.damian.broker.api.ClientController;
import com.example.damian.broker.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ClientProvider {

    @Autowired
    private ClientController clientController;

    @Scheduled(fixedDelay = 5000)
    public void createClient() {
        var client = new Client();
        client.setName("client A");
        client.setUrl("https://5b7488a2-bcfa-4fcd-a922-059c386cc57d.mock.pstmn.io/test");
        client.setMessageType("A");
        clientController.addClient(client);
    }
}
