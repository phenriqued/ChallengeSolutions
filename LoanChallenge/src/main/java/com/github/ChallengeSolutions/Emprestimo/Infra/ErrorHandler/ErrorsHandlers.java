package com.github.ChallengeSolutions.Emprestimo.Infra.ErrorHandler;


import com.github.ChallengeSolutions.Emprestimo.Infra.Exceptions.CustomerException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorsHandlers {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handler400error(MethodArgumentNotValidException exception){
        var errors = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(errors.stream().map(DataErrorValidationDTO::new).toList());
    }

    @ExceptionHandler(CustomerException.class)
    public ResponseEntity handlerCustomerException(CustomerException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
    private record DataErrorValidationDTO(String fieldError, String defaultMessage){
        public DataErrorValidationDTO(FieldError fieldError){
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}
