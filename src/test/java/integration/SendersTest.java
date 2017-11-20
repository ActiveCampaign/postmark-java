package integration;

import base.BaseTest;
import com.wildbit.java.postmark.client.AccountApiClient;
import com.wildbit.java.postmark.client.Parameters;
import com.wildbit.java.postmark.client.data.model.domains.DomainDetails;
import com.wildbit.java.postmark.client.data.model.domains.Domains;
import com.wildbit.java.postmark.client.data.model.senders.SignatureDetails;
import com.wildbit.java.postmark.client.data.model.senders.Signatures;
import com.wildbit.java.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by bash on 11/14/17.
 */
public class SendersTest extends BaseTest {

    AccountApiClient client = getDefaultAccountApiClient();

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


}
