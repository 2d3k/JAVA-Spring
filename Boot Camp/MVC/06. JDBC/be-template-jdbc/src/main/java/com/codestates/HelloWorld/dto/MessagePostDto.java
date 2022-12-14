package com.codestates.HelloWorld.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class MessagePostDto {
    @NotBlank
    private String message;
}
