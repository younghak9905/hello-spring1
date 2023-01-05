import domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import repository.MemoryMemberRepository;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repositoryTest = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repositoryTest.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("0hak");
        member.setId("you");
        member.setPassword("1234");

        repositoryTest.save(member);

        Member result = repositoryTest.findByNo(member.getNo()).get();
        System.out.println("result = " + (result == member));

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("0hak");
        repositoryTest.save(member1);

        Member member2 = new Member();
        member2.setName("0hak2");
        repositoryTest.save(member2);

        Member result = repositoryTest.findByName("0hak").get();

        //then
        assertThat(result).isEqualTo(member1);


    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("0hak");
        repositoryTest.save(member1);

        Member member2 = new Member();
        member2.setName("0hak2");
        repositoryTest.save(member2);

        //when
        List<Member> result = repositoryTest.findAll();

        //then
        assertThat(result.size()).isEqualTo(2);


    }

}
