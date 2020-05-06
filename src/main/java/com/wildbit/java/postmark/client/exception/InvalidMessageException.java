package com.wildbit.java.postmark.client.exception;

import com.wildbit.java.postmark.client.data.model.PostmarkError;

/**
 * Group of classes that identifies main Postmark API exceptions.
 */

public class InvalidMessageException extends PostmarkException {
    public InvalidMessageException(PostmarkError error) {
        super(error.getMessage(), error.getErrorCode());
    }
}


