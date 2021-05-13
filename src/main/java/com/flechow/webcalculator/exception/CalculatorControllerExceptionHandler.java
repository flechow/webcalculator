package com.flechow.webcalculator.exception;

import com.flechow.webcalculator.controler.calculator.CalculatorController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice(assignableTypes = CalculatorController.class)
public class CalculatorControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.error(ex.getMessage());
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors().stream()
                .map(f -> new FieldError(f.getObjectName(), f.getField(), f.getCode()))
                .collect(Collectors.toList());

        return new ResponseEntity<>("Method argument not valid, fieldErrors:" + fieldErrors, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler({IllegalArgumentException.class, ValidationException.class})
    public ResponseEntity<Object> handleException(Exception exception) {
        log.error(exception.getMessage());
        return new ResponseEntity<>(createBody(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    private Map<String, ? extends Comparable<? extends Comparable<?>>> createBody(String message) {
        return Map.of("timestamp", LocalDateTime.now(), "message", message);
    }
}
