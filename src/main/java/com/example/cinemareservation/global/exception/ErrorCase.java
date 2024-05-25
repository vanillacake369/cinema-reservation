package com.example.cinemareservation.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCase {
    /* Common */
    INVALID_INPUT(HttpStatus.BAD_REQUEST, 1000, "Invalid Input Parameter"),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, 1001, "Resource Not Exists"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 1002, "Internal Server Error");

    private final HttpStatus httpStatus;
    private final Integer code;
    private final String message;
}
