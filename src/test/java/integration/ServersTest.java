package integration;

import base.BaseTest;
import com.wildbit.java.postmark.client.AccountApiClient;
import com.wildbit.java.postmark.client.Parameters;
import com.wildbit.java.postmark.client.data.model.servers.Servers;
import com.wildbit.java.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by bash on 11/14/17.
 */
public class ServersTest extends BaseTest {

    AccountApiClient client = getDefaultAccountApiClient();

    @Test
    void list() throws PostmarkException, IOException {
        Servers servers = client.getServers(Parameters.init().build("count", 5).build("offset", 0));
        assertTrue(servers.getServers().size() > 0);
        assertTrue(servers.getTotalCount() > 0);
    }

}
