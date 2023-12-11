package com.AboussororAbderrahmane.aftas.controllers;

import com.AboussororAbderrahmane.aftas.dtos.Response;
import com.AboussororAbderrahmane.aftas.dtos.fish.RequestFishDTO;
import com.AboussororAbderrahmane.aftas.exceptions.InvalidDataException;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.services.implementations.FishService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/fish")
@CrossOrigin
public class FishController {
    private final FishService fishService;
    @GetMapping
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("fishes", fishService.findAll()))
                        .message("Fishes retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("/{name}")
    public ResponseEntity<Response> get(@PathVariable String name) throws NotFoundException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("fish", fishService.findById(name)))
                        .message("Fish retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody RequestFishDTO fish) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("fish", fishService.save(fish)))
                        .message("Fish created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
    @PutMapping("/{name}")
    public ResponseEntity<Response> update(@Valid @RequestBody RequestFishDTO fish, @PathVariable String name) throws NotFoundException, InvalidDataException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("fish", fishService.update(name, fish)))
                        .message("Fish updated")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @DeleteMapping("/{name}")
    public ResponseEntity<Response> delete(@PathVariable String name) throws NotFoundException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("deleted", fishService.delete(name)))
                        .message("Fish deleted")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
