### Spring WebFlux를 사용하는 이유?
> 전통적인 Spring MVC 방식의 애플리케이션보다 대량의 클라이언트 요청을 조금 더 효율적으로 처리할 수 있음

### Spring WebFlux?
> spring 5부터 지원하는 **리액티브** 웹 애플리케이션을 위한 웹 프레임워크  

| 특징    | Spring WebFlux                                                              |Spring MVC|
|-------|-----------------------------------------------------------------------------|---|
| 통신    | Non-Blocking                                                                |Blocking|
| 라이브러리 | Reactive Adapter를 사용<br/><br/>Reactor , RxJava  등 <br/>다수의 리액티브 라이브러리 사용 가능 |Servlet API의 스펙에 의존적|
| 보안    | Spring Security<br/>WebFilter를 사용해 리액티브 특성에 맞게 인증과 권한 등의 보안을 적용                                                           |Spring Security|

### Spring WebFlux와 Spring MVC 기술 스택 비교
![](https://docs.spring.io/spring-framework/docs/5.2.5.RELEASE/spring-framework-reference/images/spring-mvc-and-webflux-venn.png)