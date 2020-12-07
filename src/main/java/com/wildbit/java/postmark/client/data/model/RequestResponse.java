package com.wildbit.java.postmark.client.data.model;

public class RequestResponse {
    private Integer errorCode;
    private String message;

    // SETTERS AND GETTERS

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
