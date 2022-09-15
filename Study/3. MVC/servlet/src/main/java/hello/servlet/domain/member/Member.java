package hello.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

// 회원 관리 웹 애플리케이션 요구사항
// 회원정보(이름, 나이), 기능 요구사항(회우너저장, 목록 조회)
@Getter @Setter
public class Member {

    private Long id;
    private String username;
    private int age;

    // 기본 생성자
    public Member() {
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }
}
