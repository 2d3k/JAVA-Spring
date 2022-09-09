package hello.core.singleton;

// 싱글톤 방식의 주의점
public class StatefulService {

    private int price;      // 상태를 유지하는 필드 (설아 10000 -> 보나 20000)

    public void order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);

        this.price = price;     // 여기가 문제!
    }

    public int getPrice() {
        return price;
    }
}

