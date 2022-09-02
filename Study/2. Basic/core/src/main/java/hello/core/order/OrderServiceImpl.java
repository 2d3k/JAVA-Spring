package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //주문서비스에 필요한 2가지
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

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
