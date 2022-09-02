package hello.core.member;

public interface MemberRepository {
    //회원을 저장
    void save(Member member);

    //회원의 Id를 찾는 기능
    Member findById(Long memberId);
}
