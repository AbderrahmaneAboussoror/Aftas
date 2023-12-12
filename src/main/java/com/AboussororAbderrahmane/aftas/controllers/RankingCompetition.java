package com.AboussororAbderrahmane.aftas.controllers;

import com.AboussororAbderrahmane.aftas.dtos.Response;
import com.AboussororAbderrahmane.aftas.dtos.ranking.RequestRankingDTO;
import com.AboussororAbderrahmane.aftas.entities.RankingId;
import com.AboussororAbderrahmane.aftas.exceptions.InvalidDataException;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.services.implementations.RankingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ranking")
@CrossOrigin
public class RankingCompetition {
    private final RankingService rankingService;

    @GetMapping
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("rankings", rankingService.findAll()))
                        .message("Rankings retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("/{memberNum}/{competitionCode}")
    public ResponseEntity<Response> get(@PathVariable int memberNum, @PathVariable String competitionCode) throws NotFoundException {
        RankingId rankingId = new RankingId(memberNum, competitionCode);
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("ranking", rankingService.findById(rankingId)))
                        .message("Ranking retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("/{competitionCode}")
    public ResponseEntity<Response> getByCompetition(@PathVariable String competitionCode) throws NotFoundException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("ranking", rankingService.findByCompetition(competitionCode)))
                        .message("Ranking retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody RequestRankingDTO ranking) throws InvalidDataException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("ranking", rankingService.save(ranking)))
                        .message("Ranking created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
}
