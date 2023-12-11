package com.AboussororAbderrahmane.aftas.controllers;

import com.AboussororAbderrahmane.aftas.dtos.Response;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.services.implementations.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
@CrossOrigin
public class MemberController {
    private final MemberService memberService;

    @GetMapping
    public ResponseEntity<Response> getAll() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("members", memberService.findAll()))
                        .message("Members retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @GetMapping("/{num}")
    public ResponseEntity<Response> get(@PathVariable int num) throws NotFoundException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("member", memberService.findById(num)))
                        .message("Member retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
