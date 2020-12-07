package com.wildbit.java.postmark.client;

import com.wildbit.java.postmark.client.data.DataHandler;
import com.wildbit.java.postmark.client.data.model.PostmarkError;
import com.wildbit.java.postmark.client.exception.*;

import java.io.IOException;

/**
 * Handlers errors returned by Http client. Main use of the class is to parse Postmark errors based on error content.
 */
public class HttpClientErrorHandler {
    protected final DataHandler dataHandler;

    public HttpClientErrorHandler(DataHandler dataHandler) {
        this.dataHandler = dataHandler;
    }
    /**
     *
     * Validates HTTP request responses.
     *
     * @param statusCode - HTTP status code
     * @param message - HTTP response message
     * @return postmark error
     *
     * @throws java.io.IOException in case invalid HTTP response is returned.
     */
    public PostmarkException throwErrorBasedOnStatusCode(Integer statusCode, String message) throws IOException {
        switch (statusCode) {
            case 401:
                return new InvalidAPIKeyException(postmarkErrorFromResponse(message));

            case 408:
                return new TimeoutException(message);

            case 422:
                return new InvalidMessageException(postmarkErrorFromResponse(message));

            case 500:
                return new InternalServerException(message);

            default:
                return new UnknownException(message);

        }
    }

    /**
     *
     * Parse postmark error message from string
     *
     * @param message - error message
     * @return - Postmark error object
     * @throws IOException
     */
    private PostmarkError postmarkErrorFromResponse(String message) throws IOException{
        return dataHandler.fromJson(message, PostmarkError.class);
    }
}
