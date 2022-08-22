package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository { // 인터페이스
    Member save(Member member);
    Optional<Member> findById(Long id); // 해당 값이 널이 반환될수가 있는데 이때 널은 Optional 로 감싸서 반환됨
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
