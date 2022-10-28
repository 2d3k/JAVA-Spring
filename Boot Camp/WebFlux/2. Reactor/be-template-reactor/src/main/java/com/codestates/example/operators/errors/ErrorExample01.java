package com.codestates.example.operators.errors;

import com.codestates.example.operators.sample_data.Coffee;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

// error(): 의도적으로 onError Signal 이벤트를 발생시킬 때 사용
@Slf4j
public class ErrorExample01 {
    public static void main(String[] args) {
        Mono.justOrEmpty(findVerifiedCoffee())
                .switchIfEmpty(Mono.error(new RuntimeException("Not find coffee")))
                .subscribe(
                        data -> log.info("{} : {}", data.getKorName(), data.getPrice()),
                        error -> log.error("# onError: {}", error.getMessage()));
    }

    private static Coffee findVerifiedCoffee() {
        return null;
    }
}
