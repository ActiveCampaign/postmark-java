package com.wildbit.java.postmark.client.data.model.message;
import java.util.Date;

/**
 * HTTP send request response POJO
 */
public class BaseMessageResponse {
    private Integer errorCode;
    private String message;

    // SETTERS AND GETTERS

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
