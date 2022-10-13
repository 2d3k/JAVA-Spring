package com.codestates.example.operators.transformation;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;

// zip() 기본 예제
// zip(): 입력으로 전달되는 여러 개의 Publisher Sequence에서 emit된 데이터를 결합
// 결합: 각 Publisher가 emit하는 데이터를 하나씩 전달 받아서 새로운 데이터를 만든 후에 Downstream으로 전달
@Slf4j
public class ZipExample01 {
    public static void main(String[] args) throws InterruptedException {
        Flux<Long> source1 = Flux.interval(Duration.ofMillis(200L)).take(4);
        Flux<Long> source2 = Flux.interval(Duration.ofMillis(400L)).take(6);

        Flux
                .zip(source1, source2, (data1, data2) -> data1 + data2)
                .subscribe(data -> log.info("# onNext: {}", data));

        Thread.sleep(3000L);
    }
}
