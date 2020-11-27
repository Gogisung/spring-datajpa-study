package study.datajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.datajpa.entity.Member;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    @Test
    public void testMember() {
        Member member = new Member("memberA");
        Member save = memberRepository.save(member);

        Member member1 = memberRepository.findById(save.getId()).get();

        assertThat(member1.getId()).isEqualTo(member.getId());
        assertThat(member1.getUsername()).isEqualTo(member.getUsername());
        assertThat(member1).isEqualTo(member);
    }

}