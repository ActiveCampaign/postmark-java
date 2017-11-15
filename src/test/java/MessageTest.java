import com.wildbit.java.postmark.Postmark;
import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.data.model.message.Message;
import com.wildbit.java.postmark.client.data.model.message.MessageResponse;
import com.wildbit.java.postmark.client.exception.PostmarkException;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;


/**
 * Created by bash on 11/14/17.
 */
public class MessageTest extends BaseTest {

    ApiClient client = Postmark.getApiClient("POSTMARK_API_TEST", true);

    @Test
    void bounce() throws PostmarkException, IOException {
        Message message = new Message("from@example.com", "to@example.com", "Hello from Postmark!", "Hello body");
        MessageResponse response = client.deliverMessage(message);
        assertEquals(response.getMessage(),"Test job accepted");
        assertEquals(response.getErrorCode(), new Integer(0));
    }
}
