package client;

import org.junit.jupiter.api.Test;
import com.wildbit.java.postmark.client.HttpClient;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



//@ExtendWith(MockitoExtension.class)
public class HttpClientTests {

    private String test = "name";

    HttpClient client = mock(HttpClient.class);

    @Test
    void execute() {

        ArrayList<Integer> hey = mock(ArrayList.class);
        when(hey.get(0)).thenReturn(5);

        assertEquals(hey.get(0),(Integer)5);

    }
}
