import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.Parameters;
import com.wildbit.java.postmark.client.data.model.bounces.Bounce;
import com.wildbit.java.postmark.client.data.model.bounces.BounceDump;
import com.wildbit.java.postmark.client.data.model.bounces.Bounces;
import com.wildbit.java.postmark.client.data.model.bounces.DeliveryStats;
import com.wildbit.java.postmark.client.exception.PostmarkException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by bash on 11/14/17.
 */
public class BounceTest extends BaseTest {

    ApiClient client = getDefaultApiClient();

    @Test
    void deliveryStats() throws PostmarkException, IOException {
        DeliveryStats deliveryStats = client.getDeliveryStats();

        assertTrue(deliveryStats.getBounces().size() > 0);
        assertNotNull(deliveryStats.getBounces().get(0).getName());
        assertNotNull(deliveryStats.getBounces().get(0).getCount());
    }

    @Test
    void bounceList() throws PostmarkException, IOException {
        Bounces bounces = client.getBounces(Parameters.init().build("count", 5).build("offset", 0));

        assertTrue(bounces.getTotalCount() > 0);
        assertNotNull(bounces.getBounces().get(0).getBouncedAt());
    }

    @Test
    void bounceById() throws PostmarkException, IOException {
        Bounces bounces = client.getBounces(Parameters.init().build("count", 1).build("offset", 0));
        Integer bounceId = bounces.getBounces().get(0).getId();

        Bounce bounce = client.getBounce(bounceId);
        assertNotNull(bounce.getDescription());
    }

    @Test
    void bounceByIdDump() throws PostmarkException, IOException {
        Bounces bounces = client.getBounces(Parameters.init().build("count", 1).build("offset", 0));
        Integer bounceId = bounces.getBounces().get(0).getId();

        BounceDump bounceDump = client.getBounceDump(bounceId);
        assertNotNull(bounceDump.getBody());

    }

    @Test
    void bounceTags() throws PostmarkException, IOException {
        ArrayList<String> bounceTags = client.getBounceTags();

        assertTrue(bounceTags.size() > 0);
        assertNotNull(bounceTags.get(0));
    }

}
