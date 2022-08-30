package com.codestates.HelloWorld.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageResponseDto {
    private long messageId;
    private String message;
}
