package com.AboussororAbderrahmane.aftas.entities;

import jakarta.persistence.*;
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

@Entity
public class Competition {
    @Id
    private String code;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalDateTime startTime;
    @Column(nullable = false)
    private LocalDateTime endTime;
    @Column(nullable = false)
    private int numberOfParticipants;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false)
    private double amount;
    @OneToMany(mappedBy = "competition", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Hunting> huntingList;
    @OneToMany(mappedBy = "competition", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Ranking> rankingList;
}
