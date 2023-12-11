package com.AboussororAbderrahmane.aftas.repositories;

import com.AboussororAbderrahmane.aftas.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
}
