package com.example.admin_service.exceptions;

import org.springframework.http.HttpStatus;

public class RemoteApiException extends RuntimeException {
    private final HttpStatus status;
    private final String body;

    public RemoteApiException(String body, HttpStatus status) {
        super("Remote API Error");
        this.status = status;
        this.body = body;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getBody() {
        return body;
    }
}
