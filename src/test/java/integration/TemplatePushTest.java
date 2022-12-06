package integration;

import base.BaseTest;
import com.postmarkapp.postmark.client.AccountApiClient;
import com.postmarkapp.postmark.client.data.model.templates.*;
import com.postmarkapp.postmark.client.exception.InvalidMessageException;
import com.postmarkapp.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TemplatePushTest extends BaseTest {
    AccountApiClient client = getDefaultAccountApiClient();

    @Test
    void invalidSourceDestinationTest() throws PostmarkException, IOException {
        TemplatesPushRequest pushRequest = new TemplatesPushRequest(1,1, true);
        Throwable exception = assertThrows(InvalidMessageException.class, () -> client.pushTemplates(pushRequest));
        assertEquals(exception.getMessage(), "The source and destination servers were not found.");
    }
}
