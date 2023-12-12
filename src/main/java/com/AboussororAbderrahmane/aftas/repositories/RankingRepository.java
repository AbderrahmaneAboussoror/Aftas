package com.AboussororAbderrahmane.aftas.repositories;

import com.AboussororAbderrahmane.aftas.entities.Ranking;
import com.AboussororAbderrahmane.aftas.entities.RankingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankingId> {
    Optional<Ranking> findRankingById_CompetitionCode(String s);
    int countById_CompetitionCode(String s);
}
