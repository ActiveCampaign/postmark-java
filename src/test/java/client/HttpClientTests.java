package client;

import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.BaseApiClient;
import org.junit.jupiter.api.Test;
import com.wildbit.java.postmark.client.HttpClient;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



//@ExtendWith(MockitoExtension.class)
public class HttpClientTests {

    private String test = "name";

    //HttpClient client = mock(HttpClient.class);

    @Test
    void execute() {
        ArrayList<Integer> hey = mock(ArrayList.class);
        when(hey.get(0)).thenReturn(5);
        HttpClient client = new HttpClient(new MultivaluedHashMap<>());

    }
}
