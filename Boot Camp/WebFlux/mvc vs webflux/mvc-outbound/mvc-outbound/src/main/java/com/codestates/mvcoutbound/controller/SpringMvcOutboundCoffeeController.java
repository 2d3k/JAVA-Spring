package com.codestates.mvcoutbound.controller;

import com.codestates.mvcoutbound.dto.CoffeeResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Spring MVC 기반 외부 애플리케이션의 Controller

@RestController
@RequestMapping("/v11/coffees")
public class SpringMvcOutboundCoffeeController {

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) throws InterruptedException {
        CoffeeResponseDto responseDto = new CoffeeResponseDto(coffeeId, "카페라떼", "CafeLattee", 4000);

        Thread.sleep(5000);
        return ResponseEntity.ok(responseDto);
    }
}
