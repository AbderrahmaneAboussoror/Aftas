package com.AboussororAbderrahmane.aftas.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

@Embeddable
public class RankingId implements Serializable {
    @Column(name = "member_num", nullable = false)
    private int memberNum;
    @Column(name = "competition_code", nullable = false)
    private String competitionCode;
}
