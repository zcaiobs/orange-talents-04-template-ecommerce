package br.com.zupacademy.caio.mercadolivre.exception;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionHandle {
    MessageSource messageSource;

    ExceptionHandle(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ExceptionResponse> exceptionHandle(MethodArgumentNotValidException exception){
        return exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(e -> new ExceptionResponse(e.getField(), messageSource.getMessage(e, LocaleContextHolder.getLocale())))
                .collect(Collectors.toList());
    }
}
