package com.codestates.HelloWorld.mapper;

import com.codestates.HelloWorld.dto.MessagePostDto;
import com.codestates.HelloWorld.dto.MessageResponseDto;
import com.codestates.HelloWorld.entity.Message;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message messageDtoToMessage(MessagePostDto messagePostDto);
    MessageResponseDto messageToMessageResponseDto(Message message);
}