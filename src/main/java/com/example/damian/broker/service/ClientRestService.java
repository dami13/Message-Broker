package com.example.damian.broker.service;

import com.example.damian.broker.model.Client;
import com.example.damian.broker.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Collections;
import java.util.Date;

@Service
public class ClientRestService {

    @Autowired
    private RestTemplate restTemplate;
    protected final Logger log = LoggerFactory.getLogger(ClientRestService.class);

    @Async
    public void sendNotification(Client client, Message message) {
        if (message.getExpirationDate().after(new Date())) {
            createPost(client, message);
        } else {
            log.info("ClientRestService: Message expired => " + message);
        }
    }

    private Message createPost(Client client, Message message) {
        HttpEntity<Message> entity = new HttpEntity<>(message, getHttpHeaders());
        return restTemplate.postForObject(client.getUrl(), entity, Message.class);
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return headers;
    }
}
