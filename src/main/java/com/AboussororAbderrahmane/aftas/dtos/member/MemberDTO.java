package com.AboussororAbderrahmane.aftas.dtos.member;

import com.AboussororAbderrahmane.aftas.dtos.hunting.RequestHuntingDTO;
import com.AboussororAbderrahmane.aftas.dtos.ranking.RequestRankingDTO;
import com.AboussororAbderrahmane.aftas.enums.IdentityDocumentType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private int num;
    private String name;
    private String familyName;
    private LocalDate accessionDate;
    private String nationality;
    private IdentityDocumentType identityDocument;
    private String identityNumber;
    private List<RequestHuntingDTO> huntingList;
    private List<RequestRankingDTO> rankingList;
}
