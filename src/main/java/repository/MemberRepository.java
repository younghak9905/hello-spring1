package repository;

import domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member findByEmail(String email);

    Optional<Member> findByName(String name);

    Member save(Member member);


    Optional<Object> findById(String id);

    List<Member> findAll();

     Optional<Member> findByNo(Long no);
}
