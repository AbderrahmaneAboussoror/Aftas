package com.AboussororAbderrahmane.aftas.controllers;

import com.AboussororAbderrahmane.aftas.dtos.Response;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.services.implementations.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static java.util.Map.*;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/level")
@CrossOrigin
public class LevelController {

    private final LevelService levelService;
    @GetMapping
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("levels", levelService.findAll()))
                        .message("Levels retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<Response> get(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("level", levelService.findById(id)))
                        .message("Level retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
