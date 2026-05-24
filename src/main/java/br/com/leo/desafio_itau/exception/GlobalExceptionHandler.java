package br.com.leo.desafio_itau.exception;

import br.com.leo.desafio_itau.entity.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessRuleException.class)
    public ResponseEntity<ErrorResponse> handleBusinessRule(BusinessRuleException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_CONTENT;

        ErrorResponse erro = new ErrorResponse(
                OffsetDateTime.now(),
                status.value(),
                "Erro de validação de Negócio",
                exception.getMessage(),
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(erro);
    }


    @ExceptionHandler(Exception.class)
    public  ResponseEntity<ErrorResponse> handleGenericError(Exception exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        ErrorResponse erro = new ErrorResponse(
                OffsetDateTime.now(),
                status.value(),
                "Erro Interno no Servidor",
                "Ocorreu um erro inesperado. Tente novamente mais tarde.",
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> HandleJakartaValidation(MethodArgumentNotValidException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        String mensagensDeErro = exception.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));

        ErrorResponse erro = new ErrorResponse(
                OffsetDateTime.now(),
                status.value(),
                "Erro de Validação nos Dados Enviados",
                mensagensDeErro,
                request.getRequestURI()
        );

        return ResponseEntity.status(status).body(erro);
    }
}
