package com.pfunes.spbt.EmployeeRestApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeHandlerEx {

    @ExceptionHandler
    public ResponseEntity<Response> employeeError(EmployeeNotFoundException ex){
        Response response = new Response();
        response.setId(HttpStatus.NOT_FOUND.value());
        response.setMessage(ex.getMessage());
        response.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
