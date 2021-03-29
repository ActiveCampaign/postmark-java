package unit;

import base.BaseTest;
import com.wildbit.java.postmark.Postmark;
import com.wildbit.java.postmark.client.AccountApiClient;
import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.Parameters;
import com.wildbit.java.postmark.client.data.model.bounces.Bounces;
import com.wildbit.java.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bash on 11/8/17.
 */
public class PostmarkTest extends BaseTest {

    String apiToken = "POSTMARK_API_TEST";

    @Test
    void getApiClient() throws IOException {

        assertNotNull(Postmark.getApiClient(apiToken));
    }

    @Test
    void getApiClientSecure() {
        assertNotNull(Postmark.getApiClient(apiToken, true));
    }

    @Test
    void getApiClientCustomBaseUrl() throws IOException, PostmarkException {
        ApiClient client = Postmark.getApiClient(apiToken, true, "example.com");
        assertEquals(client.getBaseUrl(), "example.com");
    }

    @Test
    void getApiClientCustomUrl() throws IOException, PostmarkException {
        ApiClient client = Postmark.getApiClient(apiToken, true, "example.com");
        assertEquals(client.getEndpointUrl("/test"), "example.com/test");
    }

    @Test
    void getAccountApiClient() {
        assertNotNull(Postmark.getAccountApiClient(apiToken));
    }

    @Test
    void getAccountApiClientSecure() {
        assertNotNull(Postmark.getAccountApiClient(apiToken,true));
    }

    @Test
    void getAccountApiClientCustomBaseUrl() throws IOException, PostmarkException {
        AccountApiClient client = Postmark.getAccountApiClient(apiToken, true, "example.com");
        assertEquals(client.getBaseUrl(), "example.com");
    }

    @Test
    void getAccountApiClientCustomUrl()throws IOException, PostmarkException {
        AccountApiClient client = Postmark.getAccountApiClient(apiToken, true, "example.com");
        assertEquals(client.getEndpointUrl("/test"), "example.com/test");
    }
}
