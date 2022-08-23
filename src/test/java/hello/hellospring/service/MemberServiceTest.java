package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
// 테스트 쉽게 만들기 command shift T
// 테스트는 한글로만들어도댐?
class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){ // dependency injection 의존 주입
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    // clear해주자
    @AfterEach
    public void afterEach(){ // 테스트는 순서와상관없이 진행되는데 이 함수는 메소드 한개의 테스트가 끝나면 내용물을 초기화시켜주는 함수
        memberRepository.clearStore();

    }

    @Test
    void 회원가입() {
        // 테스트 코드 작성 절차

        // given
        Member member1 = new Member();
        member1.setName("spring");
        member1.setId(111111L);
        // when
        Long saveId = memberService.join(member1);
        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member1.getName()).isEqualTo(findMember.getName());
        // 테스트는 정상flow도 중요하지만 예외flow가 더 중요함
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        // 1. try-catch문으로 작성
//        try{
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        // 2.
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //then
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}