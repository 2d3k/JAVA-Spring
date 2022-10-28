package com.codestates.example;

import reactor.core.publisher.Flux;

import java.awt.*;

// 마블 다이어그램을 통해서 map() Operator의 동작 방식을 이해
public class MarbleDiagramExample {

    public static void main(String[] args) {
        Flux
                .just("Green-Circle", "Orange-Circle", "Blue-Circle")   // 세 개의 문자열을 emit
                .map(figure -> figure.replace("Circle", "Rectangle"))   // 동그라미를 네모로 바꿈
                .subscribe(System.out::println);    // map() Operator 내부에서 변환된 문자열을 출력
    }
}
