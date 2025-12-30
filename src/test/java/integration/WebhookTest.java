package integration;

import base.BaseTest;
import com.postmarkapp.postmark.client.ApiClient;
import com.postmarkapp.postmark.client.Parameters;
import com.postmarkapp.postmark.client.data.model.templates.*;
import com.postmarkapp.postmark.client.data.model.webhooks.Webhook;
import com.postmarkapp.postmark.client.data.model.webhooks.Webhooks;
import com.postmarkapp.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by bash on 11/14/17.
 */
public class WebhookTest extends BaseTest {

    ApiClient client;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        client = getDefaultApiClient();
    }

    private String getUniqueWebhookUrl() {
        // Generate unique URL to avoid conflicts when tests run in parallel
        String uniqueId = UUID.randomUUID().toString().substring(0, 8);
        String jobName = System.getenv("CIRCLE_JOB");
        if (jobName != null && !jobName.isEmpty()) {
            uniqueId = jobName + "-" + uniqueId;
        }
        return "http://example.com/" + uniqueId;
    }

    @Test
    void createWebhook() throws PostmarkException, IOException {
        Webhook webhookCreated = client.createWebhook(new Webhook(getUniqueWebhookUrl()));
        assertNotNull(webhookCreated.getId());

        client.deleteWebhook(webhookCreated.getId());
    }

    @Test
    void deleteWebhook() throws PostmarkException, IOException {
        Webhook webhookCreated = client.createWebhook(new Webhook(getUniqueWebhookUrl()));
        String stringResponse = client.deleteWebhook(webhookCreated.getId());
        assertNotNull(stringResponse);
    }

    @Test
    void listWebhooks() throws PostmarkException, IOException {
        Webhooks webhooks = client.getWebhooks();
        assertNotNull(webhooks.getWebhooks());
    }

}
