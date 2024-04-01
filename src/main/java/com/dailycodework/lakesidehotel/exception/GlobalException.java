package com.dailycodework.lakesidehotel.exception;

import com.dailycodework.lakesidehotel.dto.response.ApiResponse;
import jakarta.validation.ConstraintDeclarationException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Log4j2
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> handleGlobalException(Exception ex) {
        log.error("handleGlobalException: ", ex);
        return ApiResponse.build()
                .withSuccess(false)
                .withHttpStatus(HttpStatus.BAD_REQUEST)
                .withMessage(ex.getMessage())
                .toEntity();
    }

    @ExceptionHandler(ConstraintDeclarationException.class)
    public ResponseEntity<ApiResponse> handleConstraintDeclarationException(ConstraintDeclarationException ex){
        return ApiResponse.build()
                .withHttpStatus(HttpStatus.BAD_REQUEST)
                .withMessage(ex.getMessage())
                .withSuccess(false)
                .toEntity();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, Object> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(
                (error) -> {
                    String title = error.getObjectName();
                    String message = error.getDefaultMessage();
                    errors.put(title, message);
                }
        );
        return ApiResponse.build()
                .withHttpStatus(HttpStatus.BAD_REQUEST)
                .withErrors(errors)
                .withSuccess(false)
                .toEntity();
    }
}
