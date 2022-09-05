package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    //추상화와 구체화를 둘 다 의존하는 문제가 있음 => DIP 위반
    //MemberService memberService = new MemberServiceImpl(null);

    MemberService memberService;

    @BeforeEach     //테스트 실행 전에 무조선 실행되는 에너테이션
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
}
    @Test
    void join() {

        //given: 아래의 환경이 주어졌을 때
        //vip를 만들었을 때
        Member member = new Member(1L, "SEOLA", Grade.VIP);

        //when: 아래의 실행을 했을 때
        memberService.join(member);     //MemberService에 join을 했을 때
        Member findMember = memberService.findMember(1L);   //member를 찾아서

        //then: 아래의 결과값이 나온다
        //join한 것과 find한 것이 같으면 테스트 통과
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}

