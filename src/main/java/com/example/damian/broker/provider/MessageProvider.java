package com.example.damian.broker.provider;

import com.example.damian.broker.api.MessageController;
import com.example.damian.broker.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class MessageProvider {

    @Autowired
    private MessageController messageController;

    @Scheduled(fixedDelay = 5000)
    public void createMessage() {
        var message = new Message();
        message.setTitle("testA");
        message.setContent("content testA");
        message.setMessageType("A");
        message.setExpirationDate(getDateWithOffset());
        messageController.sendMessage(message);
    }

    @Scheduled(fixedDelay = 3000)
    public void createAnotherMessage() {
        var message = new Message();
        message.setTitle("testB");
        message.setContent("content testB");
        message.setMessageType("B");
        message.setExpirationDate(getDateWithOffset());
        messageController.sendMessage(message);
    }

    private Date getDateWithOffset() {
        return new Date(new Date().getTime() + (1000 * 60));
    }

}
