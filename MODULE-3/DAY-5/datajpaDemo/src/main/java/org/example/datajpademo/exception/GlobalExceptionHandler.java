package org.example.datajpademo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,String>> handler1(ResourceNotFoundException e){
        Map<String,String > map=new LinkedHashMap<>();
        map.put("Message:",e.getMessage());
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProjectNotFound.class)
    public ResponseEntity<ProjectNotFound> handler2(ProjectNotFound e){
        ProjectNotFound  projectNotFound = new ProjectNotFound(e.getMessage());
        return  ResponseEntity.status(404).body(projectNotFound);
    }
}

