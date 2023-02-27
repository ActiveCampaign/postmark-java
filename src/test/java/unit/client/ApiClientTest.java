package unit.client;

import com.postmarkapp.postmark.Postmark;
import com.postmarkapp.postmark.client.ApiClient;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by bash on 11/13/17.
 */
public class ApiClientTest {

    Map headers = Postmark.DefaultHeaders.headers();
    ApiClient client = new ApiClient(Postmark.DEFAULTS.API_URL.value, headers);

    @Test
    void getDataHandler() {
        assertNotNull(client.getDataHandler());
    }

    @Test
    void getHttpClient() {
        assertNotNull(client.getHttpClient());
    }
}
