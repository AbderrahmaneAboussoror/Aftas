package com.AboussororAbderrahmane.aftas.dtos.fish;

import com.AboussororAbderrahmane.aftas.dtos.LevelDTO;
import com.AboussororAbderrahmane.aftas.dtos.hunting.RequestHuntingDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FishDTO {
    private String name;
    private double averageWeight;
    private LevelDTO level;
    private List<RequestHuntingDTO> huntingList;
}
