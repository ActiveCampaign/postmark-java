package com.postmarkapp.postmark.client;

import com.postmarkapp.postmark.client.data.parser.DataHandler;
import com.postmarkapp.postmark.client.data.model.PostmarkError;
import com.postmarkapp.postmark.client.exception.*;

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
    public PostmarkHttpException throwErrorBasedOnStatusCode(Integer statusCode, String message) throws IOException {
        switch (statusCode) {
            case 401:
                return new InvalidAPIKeyException(postmarkErrorFromResponse(message), statusCode);

            case 408:
                return new TimeoutException(message, statusCode);

            case 422:
                return new InvalidMessageException(postmarkErrorFromResponse(message), statusCode);

            case 500:
                return new InternalServerException(message, statusCode);

            default:
                return new UnknownException(message, statusCode);

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
