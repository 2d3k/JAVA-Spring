# 스프링 입문 - 김영한

>자바 식별자 규칙

1. 클래스 이름은 대문자의 명사로 시작
2. 메서드 이름은 소문자의 동사
3. 변수는 소문자의 명사
4. 상수는 대문자의 명사
---
> Section3 회원 관리 예제 - 백엔드 개발
#
- 인터페이스를 사용하는 이유?

    ```
    개발 코드를 수정하지 않고 사용하는 객체를 변경할 수 있다.
    그래서 비즈니스 로직이 다른 객체를 추가할 때 수정하는 것이 아니라 다른 구현 객체를 만들어서 사용할 수 있게 된다.
    즉 유지보수 측면에서 유리하다
    ```
#
- `@Override?`

    영어 의미의 그대로 덮어쓴다는 내용이다
    상위 클래스에서 정의된 변수와 메소드의 내용을, 하위 클래스에 변경하여 재정의하는 것
#
- `value()?`
특정 객체를 대상으로 value값들만 뽑아서 배열로 반환하는 메서드
#
- `stream()?`
컬렉션에 저장되어 있는 요소를 하나씩 순회하며 처리할 수 있는 메서드
#
>테스트 할 때 검증을 하는 방법 3가지

1. `assertThat(result).isEqualTo(member);`
2. `Assertions.assertEquals(member, result);`
3. `System.out.println("result = " + (result == member));`

---

> Section4 스프링 빈과 의존관계

### 1. 컴포넌트 스캔과 자동 의존관계 설정
#
- DI를 사용하는 이유
   - new로 새로 생성하면 일어나는 문제

     `private final MemberService memberService = new MemberService();`

     MemberController 외에 다른 여러 Controller들이 MemberService를 가져다 쓰는데필요한 때마다 생성하는 것이 아니라 하나만 생성하고 같이 공유해서 쓰면 됨
#
   - 스프링 컨테이너에 등록해서 쓰는 것이 유리

       ```java
       private final MemberService memberService;
       
       @Autowired
       public MemberController(MemberService memberService) {
            this.memberService = memberService;
       }
       ```
#
- @Autowired

  생성자에 @Autowired가 되어 있으면 MemberService를 스프링이 스프링 컨테이너에서 가져다 연결해줌
#
- 스프링 빈을 등록하는 2가지 방법
   - 컴포넌트 스캔과 자동 의존관계 설정
   - 자바 코드로 직접 스프링 빈 등록하기
#
- 컴포넌트 스캔 원리

  @Component 애노테이션이 있으면 스프링 빈으로 자동 등록된다.

  @Controller 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 때문이다
#
   - @Component 를 포함하는 애노테이션

     스프링 빈에 자동등록 됨

     @Controller

     @Service

     @Repository
#
- 컨트롤러, 서비스, 리포지토리

  컨트롤러: 외부 요청을 받음

  서비스: 비즈니스 로직을 만듦

  리포지토리: 데이터 저장

### 2. 자바 코드로 직접 스프링 빈 등록하기
#
- 사용방법

    ```java
    @Configuration
    public class SpringConfig {
    
        @Bean
        public MemberService memberService() {
            return new MemberService(memberRepository());
        }
    
        @Bean
        public MemberRepository memberRepository() {
            return new MemoryMemberRepository();
        }
    }
    ```

  MemberService와 MemberRepository를 스프링 빈에 등록함

  → 스프링 빈에 등록된 MemberRepository를 MemberService에 넣어줌

---

> Section5 회원 관리 예제 - 웹 MVC 개발
#
- Mapping

  `@PostMapping`: 데이터를 넣어서 전달할 때

  `@GetMapping`:데이터를 조회할 때
#
- Mapping

  `@PostMapping`: 데이터를 넣어서 전달할 때

  `@GetMapping`:데이터를 조회할 때
___
> Section6 Spring DB Access
#
@SpringBootTest : 스프링 컨테이너와 테스트를 함께 실행한다.
@Transactional : 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백한다. 이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지않는다.
---
> Section7 AOP
#
### AOP?
공통관심사항을  한 곳에 모으고 그것을 필요한 곳에 적용함


