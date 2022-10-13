package com.codestates.example.operators.create;


import reactor.core.publisher.Flux;

import java.util.stream.Stream;

// fromStream() 기본 예제
// fromStream(): Java의 Stream을 입력으로 전달 받아 emit
public class FromStreamExample01 {
    public static void main(String[] args) {
        Flux
                .fromStream(Stream.of(200, 300, 400, 500, 600)) // 전달 받은 Stream이 포함하고 있는 데이터를 차례대로 emit
                .reduce((a, b) -> a + b)    // Upstream에서 emit된 두 개의 데이터를 순차적으로 누적 처리
                .subscribe(System.out::println);
    }
}
