package com.AboussororAbderrahmane.aftas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Level {
    @Id
    @SequenceGenerator(
            name = "level_id_sequence",
            sequenceName = "level_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "level_id_sequence"
    )
    private int code;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private int points;
    @OneToMany(mappedBy = "level", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Fish> fishList;
}
