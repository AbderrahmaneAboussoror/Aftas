package com.AboussororAbderrahmane.aftas.dtos.ranking;

import com.AboussororAbderrahmane.aftas.entities.RankingId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestRankingDTO {
    private RankingId rankingId;
}
