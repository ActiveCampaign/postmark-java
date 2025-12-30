package integration;

import base.BaseTest;
import com.postmarkapp.postmark.client.AccountApiClient;
import com.postmarkapp.postmark.client.Parameters;
import com.postmarkapp.postmark.client.data.model.senders.SignatureDetails;
import com.postmarkapp.postmark.client.data.model.senders.SignatureToCreate;
import com.postmarkapp.postmark.client.data.model.senders.Signatures;
import com.postmarkapp.postmark.client.exception.PostmarkException;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by bash on 11/14/17.
 */
public class SendersTest extends BaseTest {

    AccountApiClient client;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        client = getDefaultAccountApiClient();
    }

    SignatureToCreate testSignatureObject() {
        SignatureToCreate signature = new SignatureToCreate();
        // Generate unique email to avoid conflicts when tests run in parallel
        String uniqueId = UUID.randomUUID().toString().substring(0, 8);
        String jobName = System.getenv("CIRCLE_JOB");
        if (jobName != null && !jobName.isEmpty()) {
            // Use job name (e.g., "java8", "java11") to make it unique per Java version
            uniqueId = jobName + "-" + uniqueId;
        }
        signature.setFromEmail("igor-" + uniqueId + "@wildbit.cexample.com");
        signature.setName("Igor Test " + uniqueId);
        return signature;
    }

    @Test
    void list() throws PostmarkException, IOException {
        Signatures senders = client.getSenderSignatures(Parameters.init().build("count",6).build("offset",0));
        assertTrue(senders.getTotalCount() > 0);
        assertTrue(senders.getSenderSignatures().size() > 0);

    }

    @Test
    void listById() throws PostmarkException, IOException {
        Signatures senders = client.getSenderSignatures(Parameters.init().build("count",6).build("offset",0));
        Integer senderId = senders.getSenderSignatures().get(0).getId();
        SignatureDetails senderDetails = client.getSenderSignatureDetails(senderId);
        assertNotNull(senderDetails.getConfirmed());
    }

    @Test
    void createSignature() throws PostmarkException, IOException {
        Integer senderId = null;

        SignatureDetails senderDetails = client.createSenderSignature(testSignatureObject());
        senderId = senderDetails.getId();
        assertTrue(senderId instanceof Integer);

        client.deleteSenderSignature(senderId);
    }

    @Test
    void deleteSignature() throws PostmarkException, IOException {
        SignatureDetails senderDetails = client.createSenderSignature(testSignatureObject());
        String response = client.deleteSenderSignature(senderDetails.getId());
        assertTrue(response.contains("removed"));
    }


}
