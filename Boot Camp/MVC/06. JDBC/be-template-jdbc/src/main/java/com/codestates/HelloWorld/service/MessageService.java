package com.codestates.HelloWorld.service;

import com.codestates.HelloWorld.entity.Message;
import com.codestates.HelloWorld.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }
}