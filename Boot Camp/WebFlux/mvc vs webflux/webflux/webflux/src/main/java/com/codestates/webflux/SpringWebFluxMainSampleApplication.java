package com.codestates.webflux;

import com.codestates.webflux.dto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.LocalTime;

// Spring WebFlux 기반 메인 애플리케이션을 호출하는 클라이언트 샘플 코드

@Slf4j
@SpringBootApplication
public class SpringWebFluxMainSampleApplication {

    public static void main(String[] args) {
        System.setProperty("reactor.netty.ioWorkerCount", "1");
        SpringApplication.run(SpringWebFluxMainSampleApplication.class, args);
    }

    @Bean
    public CommandLineRunner run() {
        return (String...args) -> {
            log.info("# 요청 시작 시간: {}", LocalTime.now());

            for (int i = 1; i <= 5; i++) {
                this.getCoffee()
                        .subscribe(
                                response -> {
                                    log.info("{}: coffee name: {}", LocalTime.now(), response.getKorName());
                                }
                        );
            }
        };
    }

    private Mono<CoffeeResponseDto> getCoffee() {
        String uri = "http://localhost:6060/v11/coffees/1";

        return WebClient.create()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(CoffeeResponseDto.class);
    }
}
