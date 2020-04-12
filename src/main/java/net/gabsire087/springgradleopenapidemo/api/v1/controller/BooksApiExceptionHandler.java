package net.gabsire087.springgradleopenapidemo.api.v1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import net.gabsire087.springgradleopenapidemo.api.v1.model.Error;

import java.math.BigDecimal;

@ControllerAdvice
public class BooksApiExceptionHandler {

    @ExceptionHandler({IllegalArgumentException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<Error> handleMethodArgumentNotValidException(Exception exception){
        Error error = new Error();
        error.setStatus(new BigDecimal(HttpStatus.BAD_REQUEST.value()));
        error.setMessage("Problem, one or more arguments invalid");
        error.setMeta(exception.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}
