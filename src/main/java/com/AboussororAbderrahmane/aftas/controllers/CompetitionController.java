package com.AboussororAbderrahmane.aftas.controllers;

import com.AboussororAbderrahmane.aftas.dtos.Response;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.services.implementations.CompetitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
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
}
