package com.postmarkapp.postmark.client.exception;

/**
 * Group of classes that identifies main Postmark API exceptions.
 */

public class TimeoutException extends PostmarkHttpException {
    public TimeoutException(String message, Integer statusCode) {
        super(message, statusCode);
    }
}
