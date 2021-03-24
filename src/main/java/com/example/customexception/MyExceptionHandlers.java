package com.example.customexception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MyExceptionHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class )
    public ResponseEntity<Object> handleAll(final CustomException ce) {
        logger.info(ce.getClass().getName());
        logger.error("error", ce);

        final ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ce.getLocalizedMessage(), "error occurred");
        return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
