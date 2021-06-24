package com.example.damian.broker.api;

import com.example.damian.broker.model.Message;
import org.springframework.web.bind.annotation.RequestBody;

public interface IMessageController {

    void sendMessage(Message message);
}
