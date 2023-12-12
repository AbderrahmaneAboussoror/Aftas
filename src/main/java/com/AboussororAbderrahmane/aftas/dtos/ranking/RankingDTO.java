package com.AboussororAbderrahmane.aftas.dtos.ranking;

import com.AboussororAbderrahmane.aftas.dtos.competition.RequestCompetitionDTO;
import com.AboussororAbderrahmane.aftas.dtos.member.RequestMemberDTO;
import com.AboussororAbderrahmane.aftas.entities.RankingId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RankingDTO {
    private RankingId rankingId;
    private RequestMemberDTO member;
    private RequestCompetitionDTO competition;
    private int rank;
    private int score;
}