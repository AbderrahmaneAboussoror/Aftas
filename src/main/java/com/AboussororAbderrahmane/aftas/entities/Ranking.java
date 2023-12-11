package com.AboussororAbderrahmane.aftas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Ranking implements Serializable {
    @EmbeddedId
    private RankingId id;
    private int rank;
    private int score;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("memberNum")
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("competitionCode")
    private Competition competition;
}
