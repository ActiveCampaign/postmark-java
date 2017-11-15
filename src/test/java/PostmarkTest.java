import com.wildbit.java.postmark.Postmark;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bash on 11/8/17.
 */
public class PostmarkTest extends BaseTest {

    String apiToken = "POSTMARK_API_TEST";

    @Test
    void getApiClient() throws IOException {
        Map<String, String> env = System.getenv();

        System.out.println(env.get("POSTMARK_API_KEY"));
        assertNotNull(Postmark.getApiClient(apiToken));
    }

    @Test
    void getApiClientSecure() {
        assertNotNull(Postmark.getApiClient(apiToken, true));
    }

    @Test
    void getAccountApiClient() {
        assertNotNull(Postmark.getAccountApiClient(apiToken));
    }

    @Test
    void getAccountApiClientSecure() {
        assertNotNull(Postmark.getAccountApiClient(apiToken,true));
    }
}
