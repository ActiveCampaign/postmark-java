package com.postmarkapp.postmark.client.exception;

/**
 * Group of classes that identifies main Postmark API exceptions.
 */

public class UnknownException extends PostmarkHttpException {
    public UnknownException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}

