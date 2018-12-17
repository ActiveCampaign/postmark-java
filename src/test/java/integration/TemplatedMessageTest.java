package integration;

import base.BaseTest;
import com.wildbit.java.postmark.Postmark;
import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.data.model.message.Message;
import com.wildbit.java.postmark.client.data.model.message.MessageResponse;
import com.wildbit.java.postmark.client.data.model.templates.TemplatedMessage;
import com.wildbit.java.postmark.client.exception.InvalidAPIKeyException;
import com.wildbit.java.postmark.client.exception.InvalidMessageException;
import com.wildbit.java.postmark.client.exception.PostmarkException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.HashMap;

public class TemplatedMessageTest extends BaseTest {

    ApiClient client = Postmark.getApiClient("POSTMARK_API_TEST", true);

    @Test
    void send() throws PostmarkException, IOException {
        TemplatedMessage message = new TemplatedMessage("from@example.com", "to@example.com", 1);

        Throwable exception = assertThrows(InvalidMessageException.class, () -> client.deliverMessageWithTemplate(message));
        assertEquals("The 'TemplateId' associated with this request is not valid or was not found.", exception.getMessage());
    }

    @Test
    void metadata() throws PostmarkException, IOException {
        TemplatedMessage message = new TemplatedMessage("from@example.com", "to@example.com", 1);

        HashMap<String,String> metadata = new HashMap<String, String>();
        metadata.put("test1","value1");

        message.setMetadata(metadata);
        message.addMetadata("test2","value2");
        message.addMetadata("test3","value3");

        HashMap<String,String> templatedMessageMetadata = message.getMetadata();
        assertEquals(templatedMessageMetadata.get("test1"), "value1");
        assertEquals(templatedMessageMetadata.get("test2"), "value2");
        assertEquals(templatedMessageMetadata.get("test3"), "value3");
    }
}
