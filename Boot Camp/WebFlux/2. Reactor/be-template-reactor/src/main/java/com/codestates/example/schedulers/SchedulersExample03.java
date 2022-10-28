package com.codestates.example.schedulers;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

// publishOn() 이라는 Operator를 추가
@Slf4j
public class SchedulersExample03 {
    public static void main(String[] args) throws InterruptedException {
        Flux
                .range(1, 10)
                .subscribeOn(Schedulers.boundedElastic())   //  데이터 소스에서 데이터를 emit하는 원본 Publisher의 실행 쓰레드를 지정하는 역할
                .doOnSubscribe(subscription -> log.info("# doInSubscribe"))

                .publishOn(Schedulers.parallel())   // 전달 받은 데이터를 가공 처리하는 Operator 앞에 추가해서 실행 쓰레드를 별도로 추가하는 역할
                .filter(n -> n % 2 == 0)
                .doOnNext(data -> log.info("# filter doOnNext"))    // 바로 앞에 위치한 Operator가 실행될 때, 트리거 되는 Operator

                .subscribe(data -> log.info("# onNext: {}", data));

        Thread.sleep(100L);

        // publishOn(): Operator 앞에 여러번 추가할 경우 별도의 쓰레드가 추가로 생성되지만
        // subscribeOn(): 여러 번 추가해도 하나의 쓰레드만 추가로 생성
    }
}
