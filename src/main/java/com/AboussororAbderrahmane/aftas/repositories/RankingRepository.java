package com.AboussororAbderrahmane.aftas.repositories;

import com.AboussororAbderrahmane.aftas.entities.Ranking;
import com.AboussororAbderrahmane.aftas.entities.RankingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankingId> {
}
