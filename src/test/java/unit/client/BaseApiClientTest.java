package unit.client;

import com.wildbit.java.postmark.Postmark;
import com.wildbit.java.postmark.client.BaseApiClient;
import com.wildbit.java.postmark.client.HttpClient;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MultivaluedMap;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by bash on 11/13/17.
 */
public class BaseApiClientTest {

    MultivaluedMap headers = Postmark.DefaultHeaders.headers();
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
