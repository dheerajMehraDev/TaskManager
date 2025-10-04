package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

@ControllerAdvice
public class GlobalControllerException {
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<?>  taskNotFoundExceptionHandler(TaskNotFoundException ex){
        HashMap<String, Object> map = new HashMap<>();
        map.put("timeStamp" , LocalDate.now());
        map.put("msg", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
