package hello.core.member;

public interface MemberService {

    //회원서비스의 기능 2가지 (가입, 조회)

    void join(Member member);

    Member findMember(Long memberId);
}
