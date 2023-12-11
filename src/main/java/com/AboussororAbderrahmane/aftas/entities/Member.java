package com.AboussororAbderrahmane.aftas.entities;

import com.AboussororAbderrahmane.aftas.enums.IdentityDocumentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Member {
    @Id
    @SequenceGenerator(
            name = "member_id_sequence",
            sequenceName = "member_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_id_sequence"
    )
    private int num;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String familyName;
    @Column(nullable = false)
    private LocalDate accessionDate;
    @Column(nullable = false)
    private String nationality;
    @Enumerated(EnumType.STRING)
    private IdentityDocumentType identityDocument;
    @Column(nullable = false)
    private String identityNumber;
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Hunting> huntingList;
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ranking> rankingList;
}
