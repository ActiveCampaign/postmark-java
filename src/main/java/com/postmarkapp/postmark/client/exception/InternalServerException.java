package com.postmarkapp.postmark.client.exception;

/**
 * Group of classes that identifies main Postmark API exceptions.
 */

public class InternalServerException extends PostmarkHttpException {
    public InternalServerException(String message, Integer statusCode) {
        super(message, statusCode);
    }
}