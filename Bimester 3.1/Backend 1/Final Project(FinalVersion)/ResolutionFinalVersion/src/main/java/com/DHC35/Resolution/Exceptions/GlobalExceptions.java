package com.DHC35.Resolution.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptions {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<String> tratamientoErrorResourceNotFound(BadRequestException rnfe){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("¡Error! Se presenta la siguiente novedad: "+
                rnfe.getMessage()+"\n"+rnfe.getStackTrace());
    }
}

