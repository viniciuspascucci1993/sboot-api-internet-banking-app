package com.vinicius.sbootapiinternetbankingapp.controller.exceptions;

import com.vinicius.sbootapiinternetbankingapp.service.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String OBJECT_NOT_FOUND = "Object Not Found";

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e,
                                                          HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;

        StandardError standardError = new StandardError();
        standardError.setTimestamp(System.currentTimeMillis());
        standardError.setStatus(status.value());
        standardError.setError(OBJECT_NOT_FOUND);
        standardError.setMessage(e.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(standardError);
    }
}
