package com.AboussororAbderrahmane.aftas.dtos.competition;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestCompetitionDTO {
    @Pattern(regexp = "^[a-zA-Z]{3}-([0-2]\\d|3[0-1])-(0\\d|1[0-2])-\\d{2}$", message = "Invalid competition code format")
    private String code;
    @NotNull(message = "The date field cannot be null!")
    private LocalDate date;
    @NotNull(message = "The starting time field cannot be null!")
    private LocalDateTime startTime;
    @NotNull(message = "The ending time field cannot be null!")
    private LocalDateTime endTime;
    @NotNull(message = "The number of participants cannot be null!")
    @Min(value = 0, message = "The number of participants cannot be negative!")
    private int numberOfParticipants;
    @NotNull(message = "The location cannot be null!")
    @NotEmpty(message = "The location cannot be empty!")
    private String location;
    @NotNull(message = "The amount cannot be null!")
    @Min(value = 0, message = "The amount cannot be negative!")
    private double amount;
}
