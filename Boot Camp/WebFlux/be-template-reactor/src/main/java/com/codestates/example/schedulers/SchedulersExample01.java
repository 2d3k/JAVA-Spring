package com.codestates.example.schedulers;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

// Scheduler: Reactor Sequence 상에서 처리되는 동작들을 하나 이상의 쓰레드에서 동작하도록 별도의 쓰레드를 제공
// 요약: 복잡한 멀티쓰레딩 프로세스를 단순하게 해줌
@Slf4j
public class SchedulersExample01 {
    public static void main(String[] args) {
        Flux
                .range(1, 10)
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .subscribe(data -> log.info("# onNext: {}", data));
    }
}
