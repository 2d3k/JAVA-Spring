package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService;
    OrderService orderService;

    @BeforeEach     //테스트 실행 전에 무조선 실행되는 에너테이션
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "SEALA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "BREAD", 6000);

        //SOUT로 검증하는 것이 아니라 Assertions로 검증
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(600);
    }
}