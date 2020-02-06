package integration;

import base.BaseTest;
import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.data.model.suppressions.SuppressionEntries;
import com.wildbit.java.postmark.client.data.model.suppressions.SuppressionStatuses;
import com.wildbit.java.postmark.client.data.model.suppressions.Suppressions;
import com.wildbit.java.postmark.client.exception.PostmarkException;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class SuppressionsTest extends BaseTest {
    ApiClient client = getDefaultApiClient();
    String defaultMessageStream = "outbound";

    @Test
    void getSuppressions() throws PostmarkException, IOException {
        Suppressions suppressions = client.getSuppressions(defaultMessageStream);

        assertTrue(suppressions.getSuppressions().size() >= 0);
    }

    @Test
    void createSuppression() throws PostmarkException, IOException {
        String[] addresses = { "nothing+test@example.com", "nothing+test2@example.com"};
        SuppressionStatuses suppressionStatuses = client.createSuppressions(defaultMessageStream,
                new SuppressionEntries(addresses));

        assertTrue(suppressionStatuses.getSuppressions().size() > 0);
    }

    @Test
    void deleteSuppression() throws PostmarkException, IOException {
        String[] addresses = { "nothing+test@example.com", "nothing+test2@example.com"};
        SuppressionStatuses suppressionStatuses = client.deleteSuppressions(defaultMessageStream,
                new SuppressionEntries(addresses));

        assertTrue(suppressionStatuses.getSuppressions().size() > 0);
    }
}
