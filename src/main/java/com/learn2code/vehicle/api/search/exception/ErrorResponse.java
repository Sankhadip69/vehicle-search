package com.learn2code.vehicle.api.search.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse  {

    private LocalDateTime timestamp;
    private String message;
    private String path;
    private String errorCode;

}
