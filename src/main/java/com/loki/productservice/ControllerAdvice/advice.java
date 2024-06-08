package com.loki.productservice.ControllerAdvice;

import com.loki.productservice.DTOs.ErrorDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class advice {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDTO> NullPointExceptionHandler(){
        ErrorDTO er = new ErrorDTO();
        er.setMessage("You messed up Bro!!! Please try again");
        ResponseEntity<ErrorDTO> re =
                new ResponseEntity<>(er, HttpStatusCode.valueOf(404));
        return re;
    }
}
