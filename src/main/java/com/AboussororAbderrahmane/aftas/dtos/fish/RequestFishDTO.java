package com.AboussororAbderrahmane.aftas.dtos.fish;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestFishDTO {
    @NotNull(message = "The fish name cannot be null!")
    @NotEmpty(message = "The fish name cannot be empty!")
    private String name;
    @Min(value = 500, message = "The average weight cannot be less than 500g")
    private double averageWeight;
    private int level_code;
}
