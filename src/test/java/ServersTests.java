import com.wildbit.java.postmark.client.AccountApiClient;
import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.Parameters;
import com.wildbit.java.postmark.client.data.model.server.Server;
import com.wildbit.java.postmark.client.data.model.servers.Servers;
import com.wildbit.java.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by bash on 11/14/17.
 */
public class ServersTests extends BaseTest {

    AccountApiClient client = getDefaultAccountApiClient();

    @Test
    void serverById() throws PostmarkException, IOException {

        Servers servers = client.getServers(Parameters.init().build("count", 5).build("offset", 0));
        Integer serverId = servers.getServers().get(0).getId();
        Server server = client.getServers(serverId);

        assertNotNull(server.getName());
        assertNotNull(server.getColor());
        assertNotNull(server.getInboundAddress());
        assertNotNull(server.getId());
        assertTrue(server.getApiTokens().size() > 0);

    }

    @Test
    void create() throws PostmarkException, IOException {

        Server server = new Server();
        server.setName("testThis");
        server = client.createServer(server);

        assertNotNull(server.getName());
        assertNotNull(server.getColor());
        assertNotNull(server.getInboundAddress());
        assertNotNull(server.getId());
        assertTrue(server.getApiTokens().size() > 0);

        Integer serverToDelete = server.getId();

        String response = client.deleteServer(serverToDelete);
        assertNotNull(response);

    }

    @Test
    void update() throws PostmarkException, IOException {

        Servers servers = client.getServers(Parameters.init().build("count", 5).build("offset", 0));
        Integer serverId = servers.getServers().get(0).getId();
        Server server = client.getServers(serverId);

        String oldName = server.getName();
        server.setName("newName");

        Server response = client.setServer(serverId,server);
        assertEquals(response.getName(), server.getName());

        server.setName(oldName);
        response = client.setServer(serverId, server);
        assertEquals(response.getName(), oldName);
    }

    @Test
    void list() throws PostmarkException, IOException {

        Servers servers = client.getServers(Parameters.init().build("count", 5).build("offset", 0));
        assertTrue(servers.getServers().size() > 0);
        assertTrue(servers.getTotalCount() > 0);
    }

}
