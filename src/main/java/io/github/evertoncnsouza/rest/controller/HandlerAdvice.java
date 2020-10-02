package io.github.evertoncnsouza.rest.controller;

import io.github.evertoncnsouza.rest.ApiErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class HandlerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException ex){
        List<String> errors =  ex.getBindingResult().getAllErrors()
                .stream()
                .map( erro -> erro.getDefaultMessage() )
                .collect(Collectors.toList() );
        return new ApiErrors(errors);
    }

}
