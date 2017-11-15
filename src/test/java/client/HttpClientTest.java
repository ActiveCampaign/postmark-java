package client;

import com.wildbit.java.postmark.client.BaseApiClient;
import com.wildbit.java.postmark.client.HttpClient;
import com.wildbit.java.postmark.client.HttpClientHandler;
import com.wildbit.java.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.io.IOException;
import java.util.*;

import static org.mockito.Mockito.*;

public class HttpClientTest {

    @Test
    void execute() throws IOException, PostmarkException {
        ArrayList<Integer> hey = mock(ArrayList.class);
        when(hey.get(0)).thenReturn(5);
    }
}
