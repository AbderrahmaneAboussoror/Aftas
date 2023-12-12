package com.AboussororAbderrahmane.aftas.dtos.ranking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestRankingDTO {
    private int memberNum;
    private String competitionCode;
}
