package com.sheva.exception;

import com.sheva.util.UUIDGenerator;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;

@Log4j2
@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler({CommonException.class})
    public ResponseEntity<Object> handleCommonException(Exception e) {

        ExceptionResponse response = ExceptionResponse.builder()
                .exceptionID(UUIDGenerator.generateUUID())
                .errorMessage(e.getMessage())
                .e(getClass().toString())
                .build();

        log.error(response.getErrorMessage(), response.getE(), response.getExceptionID());

        return new ResponseEntity<>(Collections.singletonMap("error", response), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {

        ExceptionResponse response = ExceptionResponse.builder()
                .exceptionID(UUIDGenerator.generateUUID())
                .errorMessage(ex.getMessage())
                .e(getClass().toString())
                .build();

        log.error(response.getErrorMessage(), response.getE(), response.getExceptionID());

        return new ResponseEntity<>(Collections.singletonMap("error", response), HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler({Exception.class})
//    public ResponseEntity<Object> handleExceptions(Exception ex) {
//
//        ExceptionResponse response = ExceptionResponse.builder()
//                .exceptionID(UUIDGenerator.generateUUID())
//                .errorMessage(ex.getMessage())
//                .e(getClass().toString())
//                .build();
//
//        log.error(response.getErrorMessage(), response.getE(), response.getExceptionID());
//
//        return new ResponseEntity<>(Collections.singletonMap("error", response), HttpStatus.INTERNAL_SERVER_ERROR);
//    }


}
