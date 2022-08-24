package Spring.practice1.repository;

import Spring.practice1.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //하나의 테스트가 끝날 때 마다 저장소나 공용 데이터를 지워줌
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("good");     //이름을 세팅함

        repository.save(member);        //저장

        Member result = repository.findById(member.getId()).get();      //값을 꺼냄

        //검증을 하는 방법 3가지
        assertThat(result).isEqualTo(member);
        //assertEquals를 사용      Assertions.assertEquals(member, result);
        //Sytem.out을 사용     System.out.println("result = " + (result == member));
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("good1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("good2");
        repository.save(member2);

        Member result = repository.findByName("good1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("good1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("good1");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
