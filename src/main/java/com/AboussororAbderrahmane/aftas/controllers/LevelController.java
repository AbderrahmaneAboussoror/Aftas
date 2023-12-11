package com.AboussororAbderrahmane.aftas.controllers;

import com.AboussororAbderrahmane.aftas.dtos.LevelDTO;
import com.AboussororAbderrahmane.aftas.dtos.Response;
import com.AboussororAbderrahmane.aftas.exceptions.InvalidDataException;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.services.implementations.LevelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static java.time.LocalDateTime.now;
import static java.util.Map.*;
import static org.springframework.http.HttpStatus.CREATED;
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
    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody LevelDTO level) throws InvalidDataException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("level", levelService.save(level)))
                        .message("Level created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
    @PutMapping("/{id}")
    public ResponseEntity<Response> update(@Valid @RequestBody LevelDTO level, @PathVariable int id) throws NotFoundException, InvalidDataException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("level", levelService.update(id, level)))
                        .message("Level updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable int id) throws NotFoundException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", levelService.delete(id)))
                        .message("Level deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
