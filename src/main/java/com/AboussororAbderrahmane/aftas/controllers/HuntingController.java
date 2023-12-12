package com.AboussororAbderrahmane.aftas.controllers;

import com.AboussororAbderrahmane.aftas.dtos.Response;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.services.implementations.HuntingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/hunting")
@CrossOrigin
public class HuntingController {
    private final HuntingService huntingService;

    @GetMapping
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("hunting list", huntingService.findAll()))
                        .message("Hunting list retrieved")
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
                        .data(of("hunting", huntingService.findById(id)))
                        .message("Hunting retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
