package Spring.practice1.service;

import Spring.practice1.domain.Member;
import Spring.practice1.repository.MemberRepository;
import Spring.practice1.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
//@Service
public class MemberService {

    private final MemberRepository memberRepository;

    //@Autowired
    //memberRepository를 직접 생성하는 것이 아니라 외부에서 가져오는 것
    //ctrl + n 생성자로 불러옴
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public long join(Member member) {

       validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    //같은 이름인 중복 회원은 가입 불가
    //ctrl + t를 사용해서 메서드 추출
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
        /*
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        });
         */
    }

    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
