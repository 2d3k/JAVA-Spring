package com.codestates.example;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

// Reactor의 기본 구성 요소
public class HelloReactorExample {

    public static void main(String[] args) throws InterruptedException {
        Flux    //여러 건의 데이터를 처리함을 의미

                .just("Hello", "Reactor")   //  Publisher의 역할
                .map(message -> message.toUpperCase())  // Publisher로부터 전달 받은 데이터를 가공하는 Operator
                .publishOn(Schedulers.parallel())   // 쓰레드 관리자 역할을 하는 Scheduler를 지정하는 Operator
                .subscribe(System.out::println,
                        error -> System.out.println(error.getMessage()),
                        () -> System.out.println("# onComplete"));

        Thread.sleep(100L);     // 동작을 지연시켜 데몬 쓰레드를 통해 리액터 시퀀스를 정상 동작하게 함
    }
}
