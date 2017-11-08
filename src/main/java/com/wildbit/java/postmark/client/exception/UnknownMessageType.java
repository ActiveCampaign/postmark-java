package com.wildbit.java.postmark.client.exception;

/**
 * Group of classes that identifies main Postmark API exceptions.
 */

public class UnknownMessageType extends PostmarkException {
    public UnknownMessageType(String message) {
        super(message);
    }
}

