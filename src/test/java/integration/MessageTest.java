package integration;

import base.BaseTest;
import com.postmarkapp.postmark.Postmark;
import com.postmarkapp.postmark.client.ApiClient;
import com.postmarkapp.postmark.client.data.model.message.Message;
import com.postmarkapp.postmark.client.data.model.message.MessageResponse;
import com.postmarkapp.postmark.client.exception.InvalidAPIKeyException;
import com.postmarkapp.postmark.client.exception.InvalidMessageException;
import com.postmarkapp.postmark.client.exception.PostmarkException;

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
    void invalidApiToken() throws PostmarkException, IOException {
        ApiClient client = Postmark.getApiClient("1991892", true);
        Message message = new Message("from@example.com", "to@example.com", "Hello from Postmark!", "Hello body");
        assertThrows(InvalidAPIKeyException.class, () -> client.deliverMessage(message));
    }
}
