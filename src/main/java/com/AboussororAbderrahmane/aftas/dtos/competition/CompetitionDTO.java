package com.AboussororAbderrahmane.aftas.dtos.competition;

import com.AboussororAbderrahmane.aftas.dtos.hunting.RequestHuntingDTO;
import com.AboussororAbderrahmane.aftas.dtos.ranking.RequestRankingDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompetitionDTO {
    private String code;
    private LocalDate date;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private int numberOfParticipants;
    private String location;
    private double amount;
    private List<RequestHuntingDTO> huntingList;
    private List<RequestRankingDTO> rankingList;
}
