package com.AboussororAbderrahmane.aftas.controllers;

import com.AboussororAbderrahmane.aftas.dtos.Response;
import com.AboussororAbderrahmane.aftas.dtos.member.RequestMemberDTO;
import com.AboussororAbderrahmane.aftas.exceptions.InvalidDataException;
import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;
import com.AboussororAbderrahmane.aftas.services.implementations.MemberService;
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
    @GetMapping("/search/{name}")
    public ResponseEntity<Response> search(@PathVariable String name) throws NotFoundException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("member(s)", memberService.find(name)))
                        .message("Member(s) retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
    @PostMapping
    public ResponseEntity<Response> create(@Valid @RequestBody RequestMemberDTO member) throws InvalidDataException {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(of("member", memberService.save(member)))
                        .message("Member created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }
}
