package com.joaovitor.newsscraper.exceptions;

public class NotFoundErrorDetails {

    private String word;
    private String message;
    private String details;

    public NotFoundErrorDetails(String word, String message, String details) {
        this.word = word;
        this.message = message;
        this.details = details;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

}
