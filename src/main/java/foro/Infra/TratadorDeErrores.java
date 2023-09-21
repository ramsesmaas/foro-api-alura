package foro.Infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class TratadorDeErrores {

    @ExceptionHandler(NoSuchElementException .class)
    public ResponseEntity tratarError500(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErrorNotFound(){
        return ResponseEntity.notFound().build();
    }
}
