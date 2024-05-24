package com.github.ChallengeSolution.SecurePassword.Infra.HandlerErrors;


import com.github.ChallengeSolution.SecurePassword.Infra.Exceptions.AggregatePasswordException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerError {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handlerArgumentNotValidException(MethodArgumentNotValidException exception){
        return ResponseEntity.badRequest().body(
                exception.getFieldErrors().stream().map(DataErrorValidationDTO::new).toList());
    }

    @ExceptionHandler(AggregatePasswordException.class)
    public ResponseEntity handlerPasswordException(AggregatePasswordException exception){
        return ResponseEntity.badRequest().body(exception.getValidatorsException());
    }



    private record DataErrorValidationDTO(String fieldError, String defaultMessage){
        public DataErrorValidationDTO(FieldError fieldError){
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
