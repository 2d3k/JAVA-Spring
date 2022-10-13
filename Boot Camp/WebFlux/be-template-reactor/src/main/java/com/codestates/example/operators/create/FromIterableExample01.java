package com.codestates.example.operators.create;

import com.codestates.example.operators.sample_data.SampleData;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

// fromIterable() 기본 예제
// fromIterable(): Java의 Iterable을 입력으로 전달 받아 emit
@Slf4j
public class FromIterableExample01 {
    public static void main(String[] args) {
        Flux
                .fromIterable(SampleData.coffeeList)
                .subscribe(coffee -> log.info("{} : {}", coffee.getKorName(), coffee.getPrice()));
    }
}
