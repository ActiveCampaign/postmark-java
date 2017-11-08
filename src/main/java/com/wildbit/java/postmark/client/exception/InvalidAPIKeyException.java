package com.wildbit.java.postmark.client.exception;

/**
 * Group of classes that identifies main Postmark API exceptions.
 */
public class InvalidAPIKeyException extends PostmarkException {
    public InvalidAPIKeyException(String message) {
        super(message);
    }
}
