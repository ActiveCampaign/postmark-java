package integration;

import base.BaseTest;
import com.postmarkapp.postmark.client.ApiClient;
import com.postmarkapp.postmark.client.data.model.server.Server;
import com.postmarkapp.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by bash on 11/14/17.
 */
public class ServerTest extends BaseTest {

    ApiClient client = getDefaultApiClient();

    @Test
    void list() throws PostmarkException, IOException {
        Server server = client.getServer();
        assertNotNull(server.getName());
    }
}
