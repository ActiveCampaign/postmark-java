package integration;

import base.BaseTest;
import com.wildbit.java.postmark.Postmark;
import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.data.model.message.Message;
import com.wildbit.java.postmark.client.data.model.message.MessageResponse;
import com.wildbit.java.postmark.client.exception.InvalidAPIKeyException;
import com.wildbit.java.postmark.client.exception.InvalidMessageException;
import com.wildbit.java.postmark.client.exception.PostmarkException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;


/**
 * Created by bash on 11/14/17.
 */
public class MessageTest extends BaseTest {

    ApiClient client = Postmark.getApiClient("POSTMARK_API_TEST", true);

    @Test
    void send() throws PostmarkException, IOException {
        Message message = new Message("from@example.com", "to@example.com", "Hello from Postmark!", "Hello body");
        MessageResponse response = client.deliverMessage(message);
        assertEquals(response.getMessage(),"Test job accepted");
        assertEquals(response.getErrorCode(), new Integer(0));
        assertEquals(response.getMessageId().length(),36);
    }

    @Test
    void invalidMessagetoSend() throws PostmarkException, IOException {
        Message message = new Message("from@example.com", null, "Hello from Postmark!", "Hello body");

        Throwable exception = assertThrows(InvalidMessageException.class, () -> client.deliverMessage(message));
        assertEquals("Zero recipients specified", exception.getMessage());
    }

    @Test
    void invalidApiToken() throws PostmarkException, IOException {
        ApiClient client = Postmark.getApiClient("1991892", true);
        Message message = new Message("from@example.com", "to@example.com", "Hello from Postmark!", "Hello body");
        assertThrows(InvalidAPIKeyException.class, () -> client.deliverMessage(message));
    }
}
