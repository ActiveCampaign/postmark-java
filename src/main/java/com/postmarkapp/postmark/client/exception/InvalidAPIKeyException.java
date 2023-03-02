package com.postmarkapp.postmark.client.exception;

import com.postmarkapp.postmark.client.data.model.PostmarkError;

/**
 * Group of classes that identifies main Postmark API exceptions.
 */
public class InvalidAPIKeyException extends PostmarkHttpException {
    public InvalidAPIKeyException(PostmarkError error, Integer statusCode) {
        super(error.getMessage(), error.getErrorCode(), statusCode);
    }
}
