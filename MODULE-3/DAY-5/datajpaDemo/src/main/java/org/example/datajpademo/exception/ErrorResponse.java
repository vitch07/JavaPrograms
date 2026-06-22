package org.example.datajpademo.exception;

//public class ErrorResponse extends RuntimeException{
//    private String message;
//    public ErrorResponse(String message) {

import lombok.AllArgsConstructor;
import lombok.Data;

////        super(message);
//        this.message = message;
//    }




    @AllArgsConstructor
    @Data
    public class ErrorResponse {
        String message;

    }



