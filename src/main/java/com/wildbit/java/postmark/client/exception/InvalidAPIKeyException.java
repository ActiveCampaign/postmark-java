package com.wildbit.java.postmark.client.exception;

import com.wildbit.java.postmark.Postmark;
import com.wildbit.java.postmark.client.data.model.PostmarkError;

/**
 * Group of classes that identifies main Postmark API exceptions.
 */
public class InvalidAPIKeyException extends PostmarkException {
    public InvalidAPIKeyException(PostmarkError error) {
        super(error.getMessage(), error.getErrorCode());
    }
}
