package Spring.practice1.repository;

import Spring.practice1.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);     //save로 저장

    //Optional: id와 name을 가져오는데 없을 수 있으면 null로 반환
    Optional<Member> findById(long id);     //findById로 찾음
    Optional<Member> findByName(String name);
    List<Member> findAll();     //findAll로 지금까지 저장된 모든 회원 리스트를 반환
}
