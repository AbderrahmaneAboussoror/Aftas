package com.AboussororAbderrahmane.aftas.dtos.hunting;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestHuntingDTO {
    private int id;
    @NotNull(message = "The number of fish cannot be null!")
    @Min(value = 0, message = "The number of fish cannot be negative!")
    private int numberOfFish;
    private String fishName;
    private int memberNum;
    private String competitionCode;
}
