package br.com.auto.client.error.exception;

import org.springframework.http.HttpStatus;

public class AutoException extends RuntimeException {
    private final HttpStatus status;

    public AutoException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
