package com.AboussororAbderrahmane.aftas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Fish {
    @Id
    private String name;
    @Column(nullable = false)
    private double averageWeight;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_code")
    private Level level;
    @OneToMany(mappedBy = "fish", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Hunting> huntingList;
}
