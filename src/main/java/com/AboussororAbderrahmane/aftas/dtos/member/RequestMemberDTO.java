package com.AboussororAbderrahmane.aftas.dtos.member;

import com.AboussororAbderrahmane.aftas.enums.IdentityDocumentType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

// Getters, Setters, Constructors, toString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestMemberDTO {
    private int num;
    @NotNull(message = "The name field cannot be null!")
    @NotEmpty(message = "The name field cannot be empty!")
    private String name;
    @NotNull(message = "The family name field cannot be null!")
    @NotEmpty(message = "The family name field cannot be empty!")
    private String familyName;
    @NotNull(message = "The accession date field cannot be null!")
    private LocalDate accessionDate;
    @NotNull(message = "The nationality field cannot be null!")
    @NotEmpty(message = "The nationality field cannot be empty!")
    private String nationality;
    @NotNull(message = "The identity document field cannot be null!")
    @NotEmpty(message = "The identity document field cannot be empty!")
    private IdentityDocumentType identityDocument;
    @NotNull(message = "The identity number field cannot be null!")
    @NotEmpty(message = "The identity number field cannot be empty!")
    private String identityNumber;
}
