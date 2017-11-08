package com.wildbit.java.postmark.client.exception;

/**
 * Group of classes that identifies main Postmark API exceptions.
 */

public class InvalidMessageException extends PostmarkException {
    public InvalidMessageException(String message) {
        super(message);
    }
}


