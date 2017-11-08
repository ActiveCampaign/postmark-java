package com.wildbit.java.postmark.client.exception;

/**
 * Group of classes that identifies main Postmark API exceptions.
 */

public class InternalServerException extends PostmarkException {
    public InternalServerException(String message) {
        super(message);
    }
}