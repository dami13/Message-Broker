package com.example.damian.broker.api;

import com.example.damian.broker.model.Client;
import com.example.damian.broker.service.ChannelFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ClientController implements IClientController {

    @Autowired
    private ChannelFacade channelFacade;

    @PostMapping("/client")
    public void addClient(@RequestBody Client client) {
        channelFacade.addClient(client);
    }
}
