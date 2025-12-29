package integration;

import base.BaseTest;
import com.postmarkapp.postmark.client.ApiClient;
import com.postmarkapp.postmark.client.Parameters;
import com.postmarkapp.postmark.client.data.model.messages.*;
import com.postmarkapp.postmark.client.exception.InvalidMessageException;
import com.postmarkapp.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import java.io.EOFException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bash on 11/14/17.
 */
public class MessagesTest extends BaseTest {

    ApiClient client;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        client = getDefaultApiClient();
    }

    @Test
    void list() throws PostmarkException, IOException {
        OutboundMessages messages = client.getMessages(Parameters.init().build("count", 4).build("offset", 0));

        assertNotNull(messages.getMessages().get(0).getMessageId());
        assertTrue(messages.getMessages().size() > 0);
    }

    @Test
    void messageById() throws PostmarkException, IOException {
        OutboundMessages messages = client.getMessages(Parameters.init().build("count", 1).build("offset", 0));
        String messageId = messages.getMessages().get(0).getMessageId();
        
        // Retry logic for transient network errors (ZLIB stream issues)
        OutboundMessageDetails message = null;
        int maxRetries = 3;
        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                message = client.getMessageDetails(messageId);
                break; // Success, exit retry loop
            } catch (EOFException e) {
                if (attempt == maxRetries) {
                    throw e; // Re-throw on final attempt
                }
                // Wait before retry (exponential backoff)
                try {
                    Thread.sleep(100 * attempt);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new IOException("Interrupted during retry", ie);
                }
            }
        }

        assertNotNull(message.getReceivedAt());
    }

    @Test
    void messageByIdWithParameters() throws PostmarkException, IOException {
        OutboundMessages messages = client.getMessages(Parameters.init().build("count", 1).build("offset", 0));
        String messageId = messages.getMessages().get(0).getMessageId();
        Parameters parameters = new Parameters().build("includeMessageContent", "Full");
        OutboundMessageDetails message = client.getMessageDetails(messageId, parameters);

        assertNotNull(message.getReceivedAt());
    }

    @Test
    void messageByIdDump() throws PostmarkException, IOException {
        OutboundMessages messages = client.getMessages(Parameters.init().build("count", 1).build("offset", 0));
        String messageId = messages.getMessages().get(0).getMessageId();

        // Retry logic for transient network errors (ZLIB stream issues)
        OutboundMessageDump messageDump = null;
        int maxRetries = 3;
        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                messageDump = client.getMessageDump(messageId);
                break; // Success, exit retry loop
            } catch (EOFException e) {
                if (attempt == maxRetries) {
                    throw e; // Re-throw on final attempt
                }
                // Wait before retry (exponential backoff)
                try {
                    Thread.sleep(100 * attempt);
                } catch (InterruptedException ie) {
                    Thread.currentThread().interrupt();
                    throw new IOException("Interrupted during retry", ie);
                }
            }
        }
        
        assertNotNull(messageDump.getBody());
    }

    @Test
    void listInbound() throws PostmarkException, IOException {
        InboundMessages inboundMessages = client.getInboundMessages(Parameters.init().build("count", 6).build("offset", 0));

        assertTrue(inboundMessages.getInboundMessages().size() > 0);
    }

    @Test
    void inboundMessageById() throws PostmarkException, IOException {
        InboundMessages inboundMessages = client.getInboundMessages(Parameters.init().build("count", 6).build("offset", 0));
        String messageId = inboundMessages.getInboundMessages().get(0).getMessageId();

        InboundMessageDetails inboundMessageDetails = client.getInboundMessageDetails(messageId);
        assertNotNull(inboundMessageDetails.getFrom());
    }

    @Test
    void exception() throws PostmarkException, IOException {
        assertThrows(InvalidMessageException.class, () -> client.getMessages(Parameters.init().build("count", -4).build("offset", 0)));
    }
}
