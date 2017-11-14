package client;

import com.wildbit.java.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.*;

import static org.mockito.Mockito.*;

public class HttpClientTests {

    @Test
    void execute() throws IOException, PostmarkException {
        ArrayList<Integer> hey = mock(ArrayList.class);
        when(hey.get(0)).thenReturn(5);
    }
}
