package apiendereco.spring.apiendereco.error;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<ApiError> handleDomainException(BadRequest domainError) {
        return ResponseEntity
                .badRequest()
                .body(new ApiError((domainError.getMessage())));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleDomainException(Exception unexpectedError) {
        String message = "Ops! Ocorreu um erro inesperado.";
        logger.error(message, unexpectedError);
        return ResponseEntity
                .internalServerError()
                .body(new ApiError(unexpectedError.getMessage()));
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException validException) {
        Map<String, String> errors = new HashMap<>();

            validException.getBindingResult().getAllErrors().forEach( erro -> {
                String nomeCampo = ((FieldError) erro).getField();
                String mensagemError = erro.getDefaultMessage();
                errors.put(nomeCampo, mensagemError);
            });

        return errors;
    }

    public record ApiError(String message){}
}
