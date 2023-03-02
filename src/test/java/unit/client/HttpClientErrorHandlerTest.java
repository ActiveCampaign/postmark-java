package unit.client;

import com.postmarkapp.postmark.client.HttpClientErrorHandler;
import com.postmarkapp.postmark.client.data.parser.DataHandler;
import com.postmarkapp.postmark.client.exception.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class HttpClientErrorHandlerTest {

    String getStringHashMap() {

        return "{\n" +
                "  \"ErrorCode\" : \"10\",\n" +
                "  \"Message\" : \"ErrorMessage\"\n" +
                "}";
    }

    @Test
    void throw401error() throws IOException, PostmarkException {
        int statusCode = 401;
        HttpClientErrorHandler errorHandler = new HttpClientErrorHandler(new DataHandler(false));
        InvalidAPIKeyException exception = (InvalidAPIKeyException) errorHandler.throwErrorBasedOnStatusCode(statusCode, getStringHashMap());

        assertEquals(exception.getErrorCode(),10);
        assertEquals(exception.getMessage(),"ErrorMessage");
        assertEquals(exception.getStatusCode(), statusCode);
    }

    @Test
    void throw408error() throws IOException, PostmarkException {
        int statusCode = 408;
        HttpClientErrorHandler errorHandler = new HttpClientErrorHandler(new DataHandler(false));
        TimeoutException exception = (TimeoutException) errorHandler.throwErrorBasedOnStatusCode(statusCode, "message");

        assertEquals(exception.getErrorCode(),null);
        assertEquals(exception.getMessage(),"message");
        assertEquals(exception.getStatusCode(), statusCode);
    }

    @Test
    void throw422error() throws IOException, PostmarkException {
        int statusCode = 422;
        HttpClientErrorHandler errorHandler = new HttpClientErrorHandler(new DataHandler(false));
        InvalidMessageException exception = (InvalidMessageException) errorHandler.throwErrorBasedOnStatusCode(statusCode, getStringHashMap());

        assertEquals(exception.getErrorCode(),10);
        assertEquals(exception.getMessage(),"ErrorMessage");
        assertEquals(exception.getStatusCode(), statusCode);
    }

    @Test
    void throw500error() throws IOException, PostmarkException {
        int statusCode = 500;
        HttpClientErrorHandler errorHandler = new HttpClientErrorHandler(new DataHandler(false));
        InternalServerException exception = (InternalServerException) errorHandler.throwErrorBasedOnStatusCode(statusCode, "message");

        assertEquals(exception.getErrorCode(),null);
        assertEquals(exception.getMessage(),"message");
        assertEquals(exception.getStatusCode(), statusCode);
    }

    @Test
    void throw501error() throws IOException, PostmarkException {
        int statusCode = 501;
        HttpClientErrorHandler errorHandler = new HttpClientErrorHandler(new DataHandler(false));
        UnknownException exception = (UnknownException) errorHandler.throwErrorBasedOnStatusCode(statusCode, "message");

        assertEquals(exception.getErrorCode(),null);
        assertEquals(exception.getMessage(),"message");
        assertEquals(exception.getStatusCode(), statusCode);
    }

}
