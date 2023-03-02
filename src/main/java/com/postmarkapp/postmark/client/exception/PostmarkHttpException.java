package com.postmarkapp.postmark.client.exception;

import com.postmarkapp.postmark.client.data.model.PostmarkError;

/**
 * Group of classes that identifies main Postmark API exceptions.
 */

public class PostmarkHttpException extends PostmarkException {
    private Integer statusCode;
    public Integer getStatusCode() {
        return statusCode;
    }
    public PostmarkHttpException(String message, Integer statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
    public PostmarkHttpException(String message, Integer errorCode, Integer statusCode) {
        super(message, errorCode);
        this.statusCode = statusCode;
    }
}
