package com.sugirotech.healthHub.infra;

import com.sugirotech.healthHub.dtos.ExceptionDTO;
import com.sugirotech.healthHub.exceptions.InvalidLoginException;
import com.sugirotech.healthHub.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerAdvice {

    // Tratamento de inserção de argumentos inválidos

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> handleArgumentNotValidException (MethodArgumentNotValidException e){
        return ResponseEntity.badRequest().body(Map.of("message",
                e.getFieldErrors().stream().map(ExceptionDTO::new).collect(Collectors.toList())));
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<Object> handleNotFoundException(Exception e) {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<Object> handleNullPointerException(Exception e) {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", "Resource not found!");

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidLoginException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ResponseEntity<Object> handleInvalidLoginException(Exception e) {
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public ResponseEntity<Object> handleIllegalArgumentException(Exception e){
        Map<String, Object> body = new HashMap<>();
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseEntity<Object> handleBadCredentialsException(Exception e){

        Map<String, Object> body = new HashMap<String, Object>();
        body.put("message", e.getMessage());

        return new ResponseEntity<>(body, HttpStatus.UNAUTHORIZED);
    }
}
