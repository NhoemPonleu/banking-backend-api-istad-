package com.example.api.exception;

import com.example.api.base.BaseError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ApiException {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseError<?> handleValidationException(MethodArgumentNotValidException ex){
        List<Map<String,String>>errors=new ArrayList<>();
        Map<String,String>errorDetails=new HashMap<>();
       for(FieldError error: ex.getFieldErrors()){
           errorDetails.put("name",error.getField());
           errorDetails.put("message",error.getDefaultMessage());
           errors.add(errorDetails);
       }
        return BaseError.builder().build();
    }
}
