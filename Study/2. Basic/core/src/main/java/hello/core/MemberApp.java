package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //AppConfig에 있는 환경설정 정보를 가지고 스프링이 빈을 스프링 컨테이너에 객체 생성한 것을 다 넣어서 관리해 줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); //첫번째는 찾을 메서드 (memberService), 두번째는 타입

//      MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "SEOLA", Grade.VIP);     //Long 타입이여서 1뒤에 L을 붙여야 됨
        memberService.join(member);


        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
