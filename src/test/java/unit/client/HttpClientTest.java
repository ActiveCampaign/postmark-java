package unit.client;

import com.wildbit.java.postmark.Postmark;
import com.wildbit.java.postmark.client.HttpClient;
import com.wildbit.java.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MultivaluedHashMap;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class HttpClientTest {

    @Test
    void execute() throws IOException, PostmarkException {
        HttpClient client = new HttpClient(new MultivaluedHashMap<>());
        HttpClient.ClientResponse response = client.execute(HttpClient.REQUEST_TYPES.GET, "https://" + Postmark.DEFAULTS.API_URL.value);

        assertNotNull(response.getMessage());
    }

    @Test
    void executeIncorrectLink() throws IOException, PostmarkException {
        HttpClient client = new HttpClient(new MultivaluedHashMap<>());
        HttpClient.ClientResponse response = client.execute(HttpClient.REQUEST_TYPES.GET, "https://" + Postmark.DEFAULTS.API_URL.value + "/someweirdlink");

        assertEquals(response.getCode(),404);
    }

    @Test
    void getClient() throws IOException, PostmarkException {
        HttpClient client = new HttpClient(new MultivaluedHashMap<>());
        assertNotNull(client.getClient());
    }
}
