package com.wildbit.java.postmark.client.exception;

/**
 * Group of classes that identifies main Postmark API exceptions.
 */

public class PostmarkException extends Exception {
    private Integer errorCode;

    public PostmarkException(String message) {
        super(message);
    }

    public PostmarkException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public Integer getErrorCode() {
        return errorCode;
    }
}
