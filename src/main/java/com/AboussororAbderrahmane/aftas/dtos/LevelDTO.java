package com.AboussororAbderrahmane.aftas.dtos;

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
public class LevelDTO {
    private int code;
    @NotEmpty(message = "The description cannot be empty!")
    private String description;
    @NotNull(message = "The points value cannot be null!")
    @Min(value = 0, message = "The points value cannot be negative!")
    private int points;
}
