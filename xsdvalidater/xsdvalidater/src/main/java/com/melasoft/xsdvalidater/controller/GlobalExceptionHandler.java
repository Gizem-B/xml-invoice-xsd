package com.melasoft.xsdvalidater.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.xml.sax.SAXException;

import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(SAXException.class)
    public ResponseEntity<Map<String, String>> handleXmlValidationException(SAXException e) {
        Map<String, String> errorResponse = Map.of(
                "error", "XML Validation Error",
                "message", "The provided XML does not conform to the XSD schema. Details: " + e.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGenericException(Exception e) {
        Map<String, String> errorResponse = Map.of(
                "error", "Internal Server Error",
                "message", e.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
