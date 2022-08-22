package hello.hellospring.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import hello.hellospring.domain.Member;

import static org.junit.jupiter.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemberRepository repository = new MemoryMemberRepository();
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
    }
}
