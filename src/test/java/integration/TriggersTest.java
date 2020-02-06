package integration;

import base.BaseTest;
import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.Parameters;
import com.wildbit.java.postmark.client.data.model.templates.*;
import com.wildbit.java.postmark.client.data.model.triggers.InboundRules;
import com.wildbit.java.postmark.client.data.model.triggers.TagMatchers;
import com.wildbit.java.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by bash on 11/14/17.
 */
public class TriggersTest extends BaseTest {

    ApiClient client = getDefaultApiClient();

    @Test
    void listInboundRuleTriggers() throws PostmarkException, IOException {
        InboundRules inboundRules = client.getInboundRules(Parameters.init().build("count",5).build("offset",0));
        assertNotNull(inboundRules.getTotalCount());
    }

}
