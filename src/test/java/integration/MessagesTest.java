package integration;

import base.BaseTest;
import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.Parameters;
import com.wildbit.java.postmark.client.data.model.messages.*;
import com.wildbit.java.postmark.client.exception.InvalidMessageException;
import com.wildbit.java.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bash on 11/14/17.
 */
public class MessagesTest extends BaseTest {

    ApiClient client = getDefaultApiClient();

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
        OutboundMessageDetails message = client.getMessageDetails(messageId);

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

        OutboundMessageDump messageDump = client.getMessageDump(messageId);
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
