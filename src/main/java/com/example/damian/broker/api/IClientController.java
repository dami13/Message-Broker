package com.example.damian.broker.api;

import com.example.damian.broker.model.Client;
import org.springframework.web.bind.annotation.RequestBody;

public interface IClientController {

    void addClient(Client client);
}
