package com.flechow.webcalculator.exception;

import com.flechow.webcalculator.controler.CalculatorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice(assignableTypes = CalculatorController.class)
public class CalculatorControllerExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class, ValidationException.class})
    public ResponseEntity<Object> handleException(Exception ex) {
        return new ResponseEntity<>(createBody(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    private Map<String, ? extends Comparable<? extends Comparable<?>>> createBody(String message) {
        return Map.of("timestamp", LocalDateTime.now(), "message", message);
    }
}
