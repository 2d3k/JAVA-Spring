package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //주문서비스에 필요한 2가지 (회원저장소와 할인정책)
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /*DIP 위반 문제 발생
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

   고정할인율을 변동할인율로 바꿈. 하지만 문제점이 생김
   추상 인터페이스(DiscountPolicy)에만 의존하는 것이 아니라 구체 클래스(FixDiscountPolicy,RATEDiscountPolicy)에도 의존하고 있음

   FixDiscountPolicy를 바꾸면 OderServuceImpl도 변경해야 됨
   따라서, DIP를 위반함
    */

    /* 해결방안: 관심사의 분리, 생성자 주입
    private DiscountPolicy discountPolicy;
    이대로 하면 discountPolicy는 null이기 때문에 nullPointException이 발생함

    이 문제를 해결하기 위해 OrderServiceImpl에 DiscountPolicy의 객체를 대신 생성하고 주입하면 됨
    AppConfig를 통해서 관리됨
     */


    //1. 주문생성 요청이 오면
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {

        //2. 회원정보 조회를 먼저 함
        Member member = memberRepository.findById(memberId);

        //3. 할인정책에 회원정보를 넘김
        //주문서비스에서 관리하지 않고 discountPolicy에서 관리함 => 단일체계원칙을 잘 지킴
        //단일체계원칙을 잘 지켰기 때문에 할인에 대한 변경이 필요할 때 할인만 바꾸면 됨, 주문은 손대지 않아도 됨
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
