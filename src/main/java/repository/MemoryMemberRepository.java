package repository;

import domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long,Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member findByEmail(String email) {
        return store.values().stream()
                .filter(member -> member.getEmail().equals(email))
                .findAny()
                .orElse(null);

    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();

    }

    @Override
    public Optional<Object> findById(String id) {
        return Optional.of(store.values().stream()
                .filter(member -> member.getName().equals(id))
                .findAny());

    }




    @Override
    public Member save(Member member) {

        member.setNo(++sequence);
        store.put(member.getNo(), member);
        return member;
    }

    public void clearStore() {
        store.clear();
    }


    public Optional<Member> findByNo(Long no) {
        return Optional.ofNullable(store.get(no));
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}

