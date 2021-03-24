package com.example.customexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandlers {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> myMessage(CustomException ce) {
        return new ResponseEntity<>(ce.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
