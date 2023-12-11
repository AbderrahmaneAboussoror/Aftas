package com.AboussororAbderrahmane.aftas.exceptions;

import com.AboussororAbderrahmane.aftas.dtos.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public Response handleNotFoundException(NotFoundException exception) {
        return Response.builder()
                .timeStamp(now())
                .statusCode(NOT_FOUND.value())
                .reason(exception.getMessage())
                .build();
    }
}
