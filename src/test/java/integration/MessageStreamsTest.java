package integration;

import base.BaseTest;
import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.Parameters;
import com.wildbit.java.postmark.client.data.model.streams.MessageStream;
import com.wildbit.java.postmark.client.data.model.streams.MessageStreams;
import com.wildbit.java.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class MessageStreamsTest extends BaseTest {

    ApiClient client = getDefaultApiClient();

    private MessageStream findMessageStream(String streamId) throws PostmarkException, IOException {
        MessageStream foundStream = null;
        for (MessageStream streamInList : client.getMessageStreams(Parameters.init().build("messageStreamType", "all")
                .build("includeArchivedStreams", "true")).getMessageStreams()) {
            if (streamInList.getId().equalsIgnoreCase(streamId)) {
                foundStream = streamInList;
                break;
            }
        }

        return foundStream;
    }


    @Test
    void list() throws PostmarkException, IOException {
        MessageStreams messages = client.getMessageStreams(Parameters.init());

        assertTrue(messages.getTotalCount() >= 2);
        assertTrue(messages.getMessageStreams().length >= 2);
    }

    @Test
    void listWithParameter() throws PostmarkException, IOException {
        MessageStreams messages = client.getMessageStreams(Parameters.init().build("messageStreamType", "Transactional"));

        assertTrue(messages.getTotalCount() >= 1);
        assertTrue(messages.getMessageStreams().length >= 1);
    }

    @Test
    void edit() throws PostmarkException, IOException {
        MessageStreams messages = client.getMessageStreams(Parameters.init().build("messageStreamType", "Transactional"));
        MessageStream stream = messages.getMessageStreams()[0];

        String newDescription = "Some description" + Integer.toString(new Random().nextInt());

        stream.setDescription(newDescription);
        client.setMessageStream(stream.getId(), stream);

        MessageStream foundStream = findMessageStream(stream.getId());
        assertTrue(foundStream.getDescription().equalsIgnoreCase(stream.getDescription()));
    }

    @Test
    void archive() throws PostmarkException, IOException {
        String streamId = "bulk1";
        MessageStreams messages = client.getMessageStreams(Parameters.init().build("messageStreamType", "all")
                .build("includeArchivedStreams", "true"));

        MessageStream foundStream = findMessageStream(streamId);

        if (foundStream == null) {
            client.createMessageStream(new MessageStream(streamId, streamId,"Broadcasts"));
        }

        else if (foundStream.getArchivedAt() != null) {
            client.unarchiveMessageStream(streamId);
        }

        client.archiveMessageStream(streamId);
        assertNotNull(findMessageStream(streamId).getArchivedAt());

    }
}
