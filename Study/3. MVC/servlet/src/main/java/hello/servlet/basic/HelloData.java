package hello.servlet.basic;

import lombok.Getter;
import lombok.Setter;

// API 메시지 바디 - JSON
@Getter
@Setter
public class HelloData {

    private String username;
    private int age;
}
