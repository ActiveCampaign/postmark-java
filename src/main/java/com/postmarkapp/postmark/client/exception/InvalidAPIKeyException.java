package com.postmarkapp.postmark.client.exception;

import com.postmarkapp.postmark.Postmark;
import com.postmarkapp.postmark.client.data.model.PostmarkError;

/**
 * Group of classes that identifies main Postmark API exceptions.
 */
public class InvalidAPIKeyException extends PostmarkException {
    public InvalidAPIKeyException(PostmarkError error) {
        super(error.getMessage(), error.getErrorCode());
    }
}
