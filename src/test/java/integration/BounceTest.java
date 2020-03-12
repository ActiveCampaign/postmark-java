package integration;

import base.BaseTest;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.Parameters;
import com.wildbit.java.postmark.client.data.model.bounces.Bounce;
import com.wildbit.java.postmark.client.data.model.bounces.BounceDump;
import com.wildbit.java.postmark.client.data.model.bounces.Bounces;
import com.wildbit.java.postmark.client.data.model.bounces.DeliveryStats;
import com.wildbit.java.postmark.client.data.model.message.BaseMessageResponse;
import com.wildbit.java.postmark.client.exception.InvalidMessageException;
import com.wildbit.java.postmark.client.exception.PostmarkException;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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
    void bounceListEmpty() throws PostmarkException, IOException {
        Bounces bounces = client.getBounces(Parameters.init().build("count", 5).build("offset", 0).build("emailFilter","notexist292random"));
        assertEquals(bounces.getTotalCount(),0);
    }

    @Test
    void invalidBounceList() throws PostmarkException, IOException {
        Throwable exception = assertThrows(InvalidMessageException.class,
                ()-> client.getBounces(Parameters.init().build("count", -1).build("offset", 0)));

    }

    @Test
    void bounceById() throws PostmarkException, IOException {
        Bounces bounces = client.getBounces(Parameters.init().build("count", 1).build("offset", 0));
        Long bounceId = bounces.getBounces().get(0).getId();

        Bounce bounce = client.getBounce(bounceId);
        assertNotNull(bounce.getDescription());
    }

    @Test
    void activateBounce() throws PostmarkException, IOException {
        Bounces bounces = client.getBounces(Parameters.init().build("count", 1).build("offset", 0).build("inactive",true));
        Long bounceId = bounces.getBounces().get(0).getId();

        String message = client.activateBounce(bounceId);
        assertNotNull(message);
    }

    @Test
    void bounceByIdDump() throws PostmarkException, IOException {
        Bounces bounces = client.getBounces(Parameters.init().build("count", 1).build("offset", 0));
        Long bounceId = bounces.getBounces().get(0).getId();

        BounceDump bounceDump = client.getBounceDump(bounceId);
        assertNotNull(bounceDump.getBody());
    }
}
