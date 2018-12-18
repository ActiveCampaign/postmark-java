package integration;

import base.BaseTest;
import com.wildbit.java.postmark.client.AccountApiClient;
import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.Parameters;
import com.wildbit.java.postmark.client.data.model.bounces.Bounce;
import com.wildbit.java.postmark.client.data.model.bounces.BounceDump;
import com.wildbit.java.postmark.client.data.model.bounces.Bounces;
import com.wildbit.java.postmark.client.data.model.bounces.DeliveryStats;
import com.wildbit.java.postmark.client.data.model.templates.*;
import com.wildbit.java.postmark.client.exception.InvalidMessageException;
import com.wildbit.java.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
