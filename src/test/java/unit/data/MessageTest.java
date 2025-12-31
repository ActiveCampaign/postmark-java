package unit.data;


import base.BaseTest;
import com.postmarkapp.postmark.client.data.parser.DataHandler;
import com.postmarkapp.postmark.client.data.model.message.Message;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

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
    void singleMessageFromRecipient() {
        Message message = new Message();

        message.setFrom("igor@example.com");
        assertEquals(message.getFrom(), "igor@example.com");
    }

    @Test
    void singleMessageFromRecipientFullName() {
        Message message = new Message();

        message.setFrom("John Smith","igor@example.com");
        assertEquals(message.getFrom(), "\"John Smith\"<igor@example.com>");
    }

    @Test
    void singleMessageToRecipient() {
        Message message = new Message();

        List<String> recipients = new ArrayList<>();
        recipients.add("igor@example.com");

        message.setTo(recipients);
        assertEquals(message.getTo(), "\"igor@example.com\"");
    }

    @Test
    void simpleMessageToRecipients() throws IOException {

        Message message = new Message();

        List<String> recipients = new ArrayList<>();
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

        List<String> recipients = new ArrayList<>();
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

        List<String> recipients = new ArrayList<>();
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
    void recipientsWithQuotesAreEscapedProperly() {
        Message message = new Message();
        String nameWithQuote = "John \"Smith\"";
        String email = "john@example.com";

        Map<String, String> recipients = new HashMap<>();
        recipients.put(nameWithQuote, email);

        message.setTo(recipients);
        assertEquals("\"John \\\"Smith\\\"\"<john@example.com>", message.getTo());

        message.setCc(recipients);
        assertEquals("\"John \\\"Smith\\\"\"<john@example.com>", message.getCc());

        message.setBcc(recipients);
        assertEquals("\"John \\\"Smith\\\"\"<john@example.com>", message.getBcc());

        message.setFrom(nameWithQuote, email);
        assertEquals("\"John \\\"Smith\\\"\"<john@example.com>", message.getFrom());
    }

    @Test
    void attachmentException() throws IOException {
        Message message = new Message();
        assertThrows(java.nio.file.NoSuchFileException.class, () -> message.addAttachment("test"));
    }

    @Test
    void addPdfAttachment() throws IOException {
        String path = getDefaultFilePath() + "/test.pdf";
        Message message = new Message("from@example.com","to@example.com","Hello world", "Hello world");
        message.addAttachment(path);
        String base64message = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(path)));

        HashMap<String,String> attachment = (HashMap<String, String>) message.getAttachments().get(0);
        assertEquals(attachment.get("ContentType"), "application/pdf");
        assertEquals(attachment.get("Name"), new File(path).getName());
        assertEquals(attachment.get("Content"), base64message);
        assertEquals(attachment.get("ContentId"), null);
    }

    @Test
    void addImageAttachment() throws IOException {
        String file = getDefaultFilePath() + "/test.jpg";
        Message message = new Message("from@example.com","to@example.com","Hello world", "Hello world");
        message.addAttachment(file);
        String base64message = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(file)));

        HashMap<String,String> attachment = (HashMap<String, String>) message.getAttachments().get(0);
        assertEquals(attachment.get("ContentType"), "image/jpeg");
        assertEquals(attachment.get("Name"), new File(file).getName());
        assertEquals(attachment.get("Content"), base64message);
        assertEquals(attachment.get("ContentId"), null);
    }

    @Test
    void addTextAttachment() throws IOException {
        String file = getDefaultFilePath() + "/test.txt";
        Message message = new Message("from@example.com","to@example.com","Hello world", "Hello world");
        message.addAttachment(file);

        HashMap<String,String> attachment = (HashMap<String, String>) message.getAttachments().get(0);
        assertEquals(attachment.get("ContentType"), "text/plain");
        assertEquals(attachment.get("Name"), new File(file).getName());
        assertNotNull(attachment.get("Content"));
        assertEquals(attachment.get("ContentId"), null);
    }

    @Test
    void addAttachmentWithContentId() throws IOException {
        String contentId = "test-id";
        String file = getDefaultFilePath() + "/test.pdf";
        Message message = new Message("from@example.com","to@example.com","Hello world", "Hello world");
        message.addAttachment(file, contentId);
        String base64message = Base64.getEncoder().encodeToString(Files.readAllBytes(Paths.get(file)));

        HashMap<String,String> attachment = (HashMap<String, String>) message.getAttachments().get(0);
        assertEquals(attachment.get("ContentType"), "application/pdf");
        assertEquals(attachment.get("Name"), new File(file).getName());
        assertEquals(attachment.get("Content"), base64message);
        assertEquals(attachment.get("ContentId"), contentId);
    }

    @Test
    void addMultipleAttachments() throws IOException {
        String contentId = "test-id";
        String file1 = getDefaultFilePath() + "/test.pdf";
        String file2 = getDefaultFilePath() + "/test.jpg";
        Message message = new Message("from@example.com","to@example.com","Hello world", "Hello world");
        message.addAttachment(file1, contentId);
        message.addAttachment(file2);
        assertEquals(message.getAttachments().size(), 2);
        assertEquals(message.getAttachments().get(0).get("ContentId"), contentId);
        assertEquals(message.getAttachments().get(1).get("ContentId"), null);
    }

}
