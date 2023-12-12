package com.AboussororAbderrahmane.aftas.dtos.ranking;

import com.AboussororAbderrahmane.aftas.dtos.competition.RequestCompetitionDTO;
import com.AboussororAbderrahmane.aftas.dtos.member.RequestMemberDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RankingDTO {
    private RequestCompetitionDTO competition;
    private RequestMemberDTO member;
    private int rank;
    private int score;
}