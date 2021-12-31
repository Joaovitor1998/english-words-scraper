package com.joaovitor.newsscraper.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundError extends RuntimeException {

    private String word;

    public NotFoundError(String word) {
        super();
        this.word = word;
    }

    public NotFoundError(String message, String word) {
        super(message);
        this.word = word;
    }

    public String getWord() {
        return word;
    }

}
