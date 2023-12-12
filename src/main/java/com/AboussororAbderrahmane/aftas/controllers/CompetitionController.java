package com.AboussororAbderrahmane.aftas.controllers;

import com.AboussororAbderrahmane.aftas.dtos.Response;
import com.AboussororAbderrahmane.aftas.dtos.competition.RequestCompetitionDTO;
import com.AboussororAbderrahmane.aftas.exceptions.InvalidDataException;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.services.implementations.CompetitionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/competition")
@CrossOrigin
public class CompetitionController {
    private CompetitionService competitionService;

    @GetMapping
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("competitions", competitionService.findAll()))
                        .message("Competitions retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("/pagination")
    public ResponseEntity<Response> pagination(Pageable pageable) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("competitions", competitionService.pagination(pageable)))
                        .message("Competitions retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("/{code}")
    public ResponseEntity<Response> get(@PathVariable String code) throws NotFoundException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("competition", competitionService.findById(code)))
                        .message("Competition retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody RequestCompetitionDTO competition) throws InvalidDataException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("competition", competitionService.save(competition)))
                        .message("Competition created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
    @PutMapping("/{code}")
    public ResponseEntity<Response> update(@Valid @RequestBody RequestCompetitionDTO competition, @PathVariable String code) throws NotFoundException, InvalidDataException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("competition", competitionService.update(code, competition)))
                        .message("Competition updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @DeleteMapping("/{code}")
    public ResponseEntity<Response> delete(@PathVariable String code) throws NotFoundException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", competitionService.delete(code)))
                        .message("Competition deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
