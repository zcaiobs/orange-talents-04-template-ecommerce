package br.com.zupacademy.caio.mercadolivre.exception;

public class ExceptionResponse {

    private final String field;
    private final String message;

    public ExceptionResponse(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
