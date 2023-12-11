package com.AboussororAbderrahmane.aftas.repositories;

import com.AboussororAbderrahmane.aftas.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findMemberByNum(Integer integer);
    List<Member> findAllByName(String s);
    List<Member> findAllByFamilyName(String s);
}
