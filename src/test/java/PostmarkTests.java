import com.wildbit.java.postmark.Postmark;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bash on 11/8/17.
 */
public class PostmarkTests {

    String apiToken = "POSTMARK_API_TEST";

    @Test
    void getApiClient() throws IOException {

        Properties prop = new Properties();
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(".properties");
        prop.load(in);

        this.getClass().getResource("test");
        System.out.println(prop.getProperty("Version"));

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
