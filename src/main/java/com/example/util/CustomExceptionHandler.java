//package com.example.util;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import java.time.LocalDateTime;
//
//@ControllerAdvice
//public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
//
//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<?> handleAllException(Exception ex, WebRequest request){
//        ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
//        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    @ExceptionHandler(UserNotFoundException.class)
//    public final ResponseEntity<?> userNotFoundException(Exception ex, WebRequest request){
//        ErrorDetails errorDetail = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(true));
//        return new ResponseEntity(errorDetail , HttpStatus.NOT_ACCEPTABLE);
//    }
//    @ExceptionHandler(NullPointerException.class)
//    public final ResponseEntity<?> nullPointerException(Exception ex, WebRequest request){
//        ErrorDetails errorDetail = new ErrorDetails(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
//        return new ResponseEntity<>(errorDetail,HttpStatus.CONFLICT);
//    }
//}
