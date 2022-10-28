package com.codestates.example.schedulers;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

// Operator를 추가해서 쓰레드를 하나 더 생성
@Slf4j
public class SchedulersExample02 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .range(1, 10)
                .subscribeOn(Schedulers.boundedElastic())   // 구독 직후에 실행되는 쓰레드가 main 쓰레드에서 Scheduler로 지정한 쓰레드로 바꿈
                .doOnSubscribe(subscription -> log.info("# doOnSubscribe"))
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .subscribe(data -> log.info("# onNext: {}", data));

        Thread.sleep(100L);
    }
}
