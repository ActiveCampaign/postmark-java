package unit.data;


import base.BaseTest;
import com.wildbit.java.postmark.client.data.DataHandler;
import com.wildbit.java.postmark.client.data.model.message.Message;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Message data tests.
 */
public class MessageTest extends BaseTest {

    DataHandler dataHandler = new DataHandler();
    String fromAddress = "igor@example.com";
    String toAddress = "john@example.com";

    @Test
    void simpleMessage() throws IOException{
        Message message = new Message(fromAddress,toAddress, "subject", "body");

        String expectedData = "{\n" +
                "  \"From\" : \"igor@example.com\",\n" +
                "  \"To\" : \"john@example.com\",\n" +
                "  \"Subject\" : \"subject\",\n" +
                "  \"HtmlBody\" : \"body\",\n" +
                "  \"Attachments\" : [ ]\n" +
                "}";

        assertEquals(dataHandler.toJson(message),expectedData);
    }


    @Test
    void simpleMessageWithHeaders() throws IOException{
        Message message = new Message(fromAddress,toAddress, "subject", "body");
        message.addHeader("test1","test1");
        message.addHeader("test2","test2");

        String expectedData = "{\n" +
                "  \"From\" : \"igor@example.com\",\n" +
                "  \"To\" : \"john@example.com\",\n" +
                "  \"Subject\" : \"subject\",\n" +
                "  \"HtmlBody\" : \"body\",\n" +
                "  \"Headers\" : [ {\n" +
                "    \"Name\" : \"test1\",\n" +
                "    \"Value\" : \"test1\"\n" +
                "  }, {\n" +
                "    \"Name\" : \"test2\",\n" +
                "    \"Value\" : \"test2\"\n" +
                "  } ],\n" +
                "  \"Attachments\" : [ ]\n" +
                "}";

        assertEquals(dataHandler.toJson(message),expectedData);

    }

    @Test
    void simpleMessageToRecipients() throws IOException {

        Message message = new Message();

        ArrayList<String> recipients = new ArrayList<>();
        recipients.add("igor@example.com");
        recipients.add("john@example.com");
        recipients.add("chris@example.com");

        message.setTo(recipients);
        assertEquals(message.getTo(), "\"igor@example.com\",\"john@example.com\",\"chris@example.com\"");

    }

    @Test
    void simpleMessageToRecipientsFullName() throws IOException {

        Message message = new Message();

        HashMap<String, String> recipients = new HashMap<>();
        recipients.put("John Smith", "john@example.com");
        recipients.put("Milan Gornik", "milan@example.com");

        message.setTo(recipients);
        assertEquals(message.getTo(), "\"John Smith\"<john@example.com>,\"Milan Gornik\"<milan@example.com>");

    }

    @Test
    void simpleMessageCcRecipients() throws IOException {

        Message message = new Message();

        ArrayList<String> recipients = new ArrayList<>();
        recipients.add("igor@example.com");
        recipients.add("john@example.com");
        recipients.add("chris@example.com");

        message.setCc(recipients);
        assertEquals(message.getCc(), "\"igor@example.com\",\"john@example.com\",\"chris@example.com\"");

    }

    @Test
    void simpleMessageCcRecipientsFullName() throws IOException {

        Message message = new Message();

        HashMap<String, String> recipients = new HashMap<>();
        recipients.put("John Smith", "john@example.com");
        recipients.put("Milan Gornik", "milan@example.com");

        message.setCc(recipients);
        assertEquals(message.getCc(), "\"John Smith\"<john@example.com>,\"Milan Gornik\"<milan@example.com>");

    }

    @Test
    void simpleMessageBccRecipients() throws IOException {

        Message message = new Message();

        ArrayList<String> recipients = new ArrayList<>();
        recipients.add("igor@example.com");
        recipients.add("john@example.com");
        recipients.add("chris@example.com");

        message.setBcc(recipients);
        assertEquals(message.getBcc(), "\"igor@example.com\",\"john@example.com\",\"chris@example.com\"");

    }

    @Test
    void simpleMessageBcccRecipientsFullName() throws IOException {

        Message message = new Message();

        HashMap<String, String> recipients = new HashMap<>();
        recipients.put("John Smith", "john@example.com");
        recipients.put("Milan Gornik", "milan@example.com");

        message.setBcc(recipients);
        assertEquals(message.getBcc(), "\"John Smith\"<john@example.com>,\"Milan Gornik\"<milan@example.com>");

    }

    @Test
    void attachmentException() throws IOException {
        Message message = new Message();
        assertThrows(java.nio.file.NoSuchFileException.class, () -> message.addAttachment("test"));
    }

    @Test
    void addAttachment() throws IOException {
        Message message = new Message("from@example.com","to@example.com","Hello world", "Hello world");
        message.addAttachment(getDefaultFilePath());

        HashMap<String,String> attachment = (HashMap<String, String>) message.getAttachments().get(0);
        assertEquals(attachment.get("ContentType"), "application/pdf");
        assertEquals(attachment.get("Name"), new File(getDefaultFilePath()).getName());
        assertNotNull(attachment.get("Content"));
    }

    @Test
    void addMultipleAttachments() throws IOException {
        Message message = new Message("from@example.com","to@example.com","Hello world", "Hello world");
        message.addAttachment(getDefaultFilePath());
        message.addAttachment(getDefaultFilePath());
        assertEquals(message.getAttachments().size(), 2);
    }

}
