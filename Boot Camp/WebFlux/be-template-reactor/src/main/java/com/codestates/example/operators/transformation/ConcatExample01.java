package com.codestates.example.operators.transformation;

import reactor.core.publisher.Flux;

// concat() 기본 예제 1
// concat() Operator: 입력으로 전달하는 Publisher의 Sequence를 연결해서 차례대로 데이터를 emit
public class ConcatExample01 {
    public static void main(String[] args) {
        Flux
                .concat(Flux.just("Monday", "Tuesday", "Wednesday", "Thursday", "Friday"),
                        Flux.just("Saturday", "Sunday"))
                .subscribe(System.out::println);
    }
}
