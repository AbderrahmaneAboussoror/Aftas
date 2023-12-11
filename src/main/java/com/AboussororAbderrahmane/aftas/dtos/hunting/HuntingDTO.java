package com.AboussororAbderrahmane.aftas.dtos.hunting;

import com.AboussororAbderrahmane.aftas.dtos.competition.RequestCompetitionDTO;
import com.AboussororAbderrahmane.aftas.dtos.fish.RequestFishDTO;
import com.AboussororAbderrahmane.aftas.dtos.member.RequestMemberDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HuntingDTO {
    private int id;
    private int numberOfFish;
    private RequestFishDTO fish;
    private RequestMemberDTO member;
    private RequestCompetitionDTO competition;
}
