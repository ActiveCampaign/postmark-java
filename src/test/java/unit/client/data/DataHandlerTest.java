package unit.client.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.wildbit.java.postmark.client.data.DataHandler;
import com.wildbit.java.postmark.client.data.model.message.BaseMessageResponse;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bash on 11/13/17.
 */
public class DataHandlerTest {

    DataHandler dataHandler = new DataHandler();

    HashMap<String, String> getHashMap() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Key1", "Value1");
        hashMap.put("Key2", "Value2");

        return hashMap;

    }

    String getStringHashMap() {

        return "{\n" +
                "  \"Key2\" : \"Value2\",\n" +
                "  \"Key1\" : \"Value1\"\n" +
                "}";
    }

    @Test
    void liberalMapper() throws IOException {
        dataHandler.setLiberalMapper();
        dataHandler.fromJson(getStringHashMap(), BaseMessageResponse.class);
    }

    @Test
    void strictMapper() throws IOException {
        dataHandler.setStrictMapper();
        Throwable exception = assertThrows(UnrecognizedPropertyException.class,
                ()-> dataHandler.fromJson(getStringHashMap(), BaseMessageResponse.class));

    }

    @Test
    void toJson() throws IOException {
        assertEquals(dataHandler.toJson(getHashMap()), getStringHashMap());
    }

    @Test
    void fromJson() throws IOException {
        HashMap<String,String> result = dataHandler.fromJson(getStringHashMap(), HashMap.class);
        assertEquals(result,getHashMap());
    }

    @Test
    void fromJsonTypeReference() throws IOException {
        HashMap<String,String> result = dataHandler.fromJson(getStringHashMap(), new TypeReference<HashMap>() {});
        assertEquals(result,getHashMap());
    }

}
