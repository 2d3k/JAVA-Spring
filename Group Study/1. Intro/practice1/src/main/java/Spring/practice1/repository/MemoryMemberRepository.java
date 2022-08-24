package Spring.practice1.repository;

import Spring.practice1.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);               //id 세팅
        store.put(member.getId(), member);      //store에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        return Optional.ofNullable(store.get(id));      //ofNullable을 사용해서 null이여도 반환할 수 있게 함
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        //member에서 member.getName이 파라미터로 받은 name과 같은지 확인 해 줌
        //같은 경우에만 필터링 됨
        //findAny: 하나라도 찾는 것
        //찾으면 반환 됨
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());     //store에 있는 members를 반환
    }

    public void clearStore() {
        store.clear();
    }
}