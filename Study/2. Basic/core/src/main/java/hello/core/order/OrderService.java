package hello.core.order;

//주문서비스 인터페이스
public interface OrderService {

    //주문생성 할 때 필요한 파라미터 (회원id, 상품명, 상품가격)
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
