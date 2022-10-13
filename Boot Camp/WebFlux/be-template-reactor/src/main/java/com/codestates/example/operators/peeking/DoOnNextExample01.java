package com.codestates.example.operators.peeking;

import com.codestates.example.operators.sample_data.SampleData;
import com.codestates.example.operators.sample_data.Coffee;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

// doOnNext() 기본 예제
// doOnNext: 데이터 emit시 트리거 되어 부수 효과(side-effect)를 추가 가능
// 함수형 프로그래밍 세계에서 부수 효과(side-effect): 어떤 동작을 실행하되 리턴 값이 없는 것을 의미
@Slf4j
public class DoOnNextExample01 {
    public static void main(String[] args) {
        Flux
                .fromIterable(SampleData.coffeeList)
                .doOnNext(coffee -> validateCoffee(coffee))
                .subscribe(data -> log.info("{} : {}", data.getKorName(), data.getPrice()));
    }
        private static void validateCoffee(Coffee coffee) {
            if (coffee == null) {
                throw new RuntimeException("Not found coffee");
            }
        }
    }