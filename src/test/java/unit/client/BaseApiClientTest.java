package unit.client;

import com.postmarkapp.postmark.Postmark;
import com.postmarkapp.postmark.client.BaseApiClient;
import com.postmarkapp.postmark.client.HttpClient;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by bash on 11/13/17.
 */
public class BaseApiClientTest {

    Map headers = Postmark.DefaultHeaders.headers();
    BaseApiClient client = new BaseApiClient(Postmark.DEFAULTS.API_URL.value, headers);

    @Test
    void getBaseUrl() {
        assertEquals(client.getBaseUrl(), Postmark.DEFAULTS.API_URL.value);
        client.getEndpointUrl("/test");
    }

    @Test
    void getEndpointUrl() {
        String endpoint = "/test";
        assertEquals(client.getEndpointUrl(endpoint), Postmark.DEFAULTS.API_URL.value + endpoint);
    }

    @Test
    void getHttpClient() {
        assertEquals(client.getHttpClient().getClass(), HttpClient.class);
    }
}
