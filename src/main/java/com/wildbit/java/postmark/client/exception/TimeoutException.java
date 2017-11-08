package com.wildbit.java.postmark.client.exception;

/**
 * Group of classes that identifies main Postmark API exceptions.
 */

public class TimeoutException extends PostmarkException {
    public TimeoutException(String message) {
        super(message);
    }
}
