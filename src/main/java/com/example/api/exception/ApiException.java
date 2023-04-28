package com.example.api.exception;
import com.example.api.base.BaseError;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
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
        return BaseError.builder()
                .message("please fill ")
                .code(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .error(errors)
                .status(true)
                .build();
    }
    @ExceptionHandler(ResponseStatusException.class)
    public BaseError<?>handleServieException(ResponseStatusException ex){
     return    BaseError.builder()
                .message("please fill ")
                .code(ex.getStatusCode().value())
                .message("Something went wrong ")
                .timestamp(LocalDateTime.now())
                .error(ex.getReason())
                .status(true)
                .build();
    }
}
