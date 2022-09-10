package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

//정액할인정책
@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;   //1000원 할인

    @Override
    public int discount(Member member, int price) {
        //enum 타입은 ==으로 사용해야 됨
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
