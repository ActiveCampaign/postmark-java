package com.wildbit.java.postmark.client.data.model;

/**
 * Postmark standard error.
 */
public class PostmarkError {

    private Integer errorCode;
    private String message;

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getErrorCode() {

        return errorCode;
    }

    public String getMessage() {
        return message;
    }
}
