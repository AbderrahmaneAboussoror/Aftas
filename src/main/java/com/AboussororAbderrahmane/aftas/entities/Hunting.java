package com.AboussororAbderrahmane.aftas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Hunting {
    @Id
    @SequenceGenerator(
            name = "hunting_id_sequence",
            sequenceName = "hunting_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "hunting_quiz_id_sequence"
    )
    private int id;
    @Column(nullable = false)
    private int numberOfFish;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fish_name")
    private Fish fish;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_num")
    private Member member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competition_code")
    private Competition competition;

}
