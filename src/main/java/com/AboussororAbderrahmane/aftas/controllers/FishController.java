package com.AboussororAbderrahmane.aftas.controllers;

import com.AboussororAbderrahmane.aftas.dtos.Response;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.services.implementations.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
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
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Fishes retrieved")
                        .build()
        );
    }
    @GetMapping("/{name}")
    public ResponseEntity<Response> get(@PathVariable String name) throws NotFoundException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("fish", fishService.findById(name)))
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Fish retrieved")
                        .build()
        );
    }
}
