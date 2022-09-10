package hello.core;

// 의존관계 자동주입에서 롬복과 최신트렌드

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {

    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("LOMBOK");

        String name = helloLombok.getName();
        System.out.println("helloLombok = " + helloLombok);
    }
}
