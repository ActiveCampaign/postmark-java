import com.wildbit.java.postmark.Postmark;
import com.wildbit.java.postmark.client.ApiClient;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bash on 11/8/17.
 */
public class PostmarkTests {

    String apiToken = "POSTMARK_API_TEST";

    @Test
    void getApiClient() {
        ApiClient client = Postmark.getApiClient(apiToken);
        assertNotNull(client.getDataHandler());
    }
}
