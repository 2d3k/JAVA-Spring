package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//    가입을 하고 조회를 하려면 MemberRepository 인터페이스가 필요함
//    그냥 인터페이스만 있으면 NullPointException이 발생
//    구현 객체를 선택해줘야 됨

@Component
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {

        memberRepository.save(member);

        //join에서 save를 호출하면 다형성에 의해 인터페이스(MemberRepository)가 아니라
        //MemoryMemberRepository에 있는 save가 호출됨
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
