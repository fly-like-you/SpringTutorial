package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import  java.util.HashMap;
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L; // key값 생성

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); /// NULL이 반환 될 가능성이 있을때
        // return store.get(id) 예전에는 이렇게 했음
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 루프를 돌면서 이름이 같으면 반환 없으면 null반환
    }

    @Override
    public List<Member> findAll() { // 실무에선 리스트가 많이 쓰인다
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }
}
// 작성한 코드가 잘 수행되는지 알고싶다? -> 테스트 케이스