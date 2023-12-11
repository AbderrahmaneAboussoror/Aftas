package com.AboussororAbderrahmane.aftas.repositories;

import com.AboussororAbderrahmane.aftas.entities.Fish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FishRepository extends JpaRepository<Fish, String> {
    Optional<Fish> findFishByName(String s);
}
