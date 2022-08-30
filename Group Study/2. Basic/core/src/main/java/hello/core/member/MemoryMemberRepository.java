package hello.core.member;

import java.util.HashMap;
import java.util.Map;

//회원 구현체
public class MemoryMemberRepository implements MemberRepository{
                                    //인터페이스 가져옴
    //저장소 만듦
    private static Map<Long, Member> store = new HashMap<>();
                                                //동시성 이슈가 있어서 실무에서는 ConcurrnetHashMap 사용
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
