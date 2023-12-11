package com.AboussororAbderrahmane.aftas.repositories;

import com.AboussororAbderrahmane.aftas.entities.Competition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, String> {
}
