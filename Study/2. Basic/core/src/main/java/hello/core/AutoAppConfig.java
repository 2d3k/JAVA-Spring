package hello.core;

// 컴포넌트 스캔과 의존관계 자동 주입
// 컴포넌트 스캔: 설정 정보가 없어도 자동으로 스프링 빈을 등록하는 기능

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        // 탐색할 패키지의 시작 위치를 지정. 이 패키지를 포함해서 하위 패키지를 모두 탐색
        basePackages = "hello.core",
        // 컴포넌트 스캔을 제외할 것을 지정함
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
