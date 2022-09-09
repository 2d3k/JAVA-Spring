package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

// 싱글톤 방식의 주의점
class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //threadA: 설아 10000원 주문
        statefulService1.order("seola", 10000);
        //threadB: 보나 20000원 주문
        statefulService2.order("bona", 20000);

        //threadA: 설아가 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    /*
    스레드A에서 설아가 만원을 주문하고 스레드B에서 보나가 이만원을 주문함
    그리고 설아가 주문 금액을 조회했는데, 중간에 보나가 껴서 price에는 이만원이 들어감
    그래서 조회 금액이 이만원이 나옴!
     */

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}