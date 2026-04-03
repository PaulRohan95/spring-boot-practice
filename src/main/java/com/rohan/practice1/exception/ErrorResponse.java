package com.rohan.practice1.exception;
import java.time.Instant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class ErrorResponse {
    private Instant timestamp;
    private int status;
    private String code;
    private String message;
    private String path;
}