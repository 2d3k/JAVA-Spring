package com.codestates.HelloWorld.controller;

import com.codestates.HelloWorld.dto.MessagePostDto;
import com.codestates.HelloWorld.entity.Message;
import com.codestates.HelloWorld.mapper.MessageMapper;
import com.codestates.HelloWorld.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequestMapping("/v1/messages")
@RestController
public class MessageController {
    private final MessageService messageService;
    private final MessageMapper mapper;

    public MessageController(MessageService messageService,
                             MessageMapper mapper) {
        this.messageService = messageService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postMessage(
            @Valid @RequestBody MessagePostDto messagePostDto) {
        Message message =
                messageService.createMessage(mapper.messageDtoToMessage(messagePostDto));

        return ResponseEntity.ok(mapper.messageToMessageResponseDto(message));
    }
}