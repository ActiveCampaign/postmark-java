package integration;

import base.BaseTest;
import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.Parameters;
import com.wildbit.java.postmark.client.data.model.templates.*;
import com.wildbit.java.postmark.client.data.model.webhooks.Webhook;
import com.wildbit.java.postmark.client.data.model.webhooks.Webhooks;
import com.wildbit.java.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by bash on 11/14/17.
 */
public class WebhookTest extends BaseTest {

    ApiClient client = getDefaultApiClient();

    @Test
    void createWebhook() throws PostmarkException, IOException {
        Webhook webhookCreated = client.createWebhook(new Webhook("http://example.com"));
        assertNotNull(webhookCreated.getId());

        client.deleteWebhook(webhookCreated.getId());
    }

    @Test
    void deleteWebhook() throws PostmarkException, IOException {
        Webhook webhookCreated = client.createWebhook(new Webhook("http://example.com"));
        String stringResponse = client.deleteWebhook(webhookCreated.getId());
        assertNotNull(stringResponse);
    }

    @Test
    void listWebhooks() throws PostmarkException, IOException {
        Webhooks webhooks = client.getWebhooks();
        assertNotNull(webhooks.getWebhooks());
    }

}
