package com.AboussororAbderrahmane.aftas.controllers;

import com.AboussororAbderrahmane.aftas.dtos.Response;
import com.AboussororAbderrahmane.aftas.services.implementations.FishService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
