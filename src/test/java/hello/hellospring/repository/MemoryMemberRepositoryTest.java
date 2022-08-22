package hello.hellospring.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import hello.hellospring.domain.Member;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach(){ // 테스트는 순서와상관없이 진행되는데 이 함수는 메소드 한개의 테스트가 끝나면 내용물을 초기화시켜주는 함수
        repository.clearStore();

    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();
        System.out.println("result = " + (result == member));

    }

    @Test
    public void findByName() {
        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member result = repository.findByName("spring1").get();

        Assertions.assertEquals(member1, result);
    }
    @Test
    public void findAll(){
        Member member2= new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);

        List<Member> result = repository.findAll();
        Assertions.assertEquals(result.size(), 2);




    }
}
