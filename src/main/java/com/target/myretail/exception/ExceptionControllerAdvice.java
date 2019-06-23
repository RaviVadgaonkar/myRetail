package com.target.myretail.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

    @SuppressWarnings("unchecked")
    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    @ResponseBody
    ResponseEntity<Object> handleException(HttpClientErrorException.NotFound ex) {
        return new ResponseEntity<>(new Error(
                "INVALID_PRODUCT",
                "We could not locate this product. Please check if the product id is correct."),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    @ResponseBody
    ResponseEntity<Object> handleException(HttpClientErrorException.BadRequest ex) {
        {
            return new ResponseEntity<>(new Error(
                    "INVALID_REQUEST",
                    "Bad Request error :" + ex.getMessage()),
                    ex.getStatusCode());
        }
    }

    @ExceptionHandler(HttpClientErrorException.class)
    @ResponseBody
    ResponseEntity<Object> handleException(HttpClientErrorException ex) {
        {
            return new ResponseEntity<>(new Error(
                    "HTTP_ERROR",
                    "HTTP Client Error:" + ex.getMessage()),
                    ex.getStatusCode());
        }
    }

    @SuppressWarnings("unchecked")
    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseEntity<Object> handleException(Exception ex) {
        return new ResponseEntity<>(new Error(
                "UNEXPECTED_ERROR",
                "Server Error :" + ex.getMessage()),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
