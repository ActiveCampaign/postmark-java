import com.wildbit.java.postmark.Postmark;
import com.wildbit.java.postmark.client.AccountApiClient;
import com.wildbit.java.postmark.client.ApiClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by bash on 11/14/17.
 */
public class BaseTest {

    private final String propertyFile = ".properties";
    public final Properties properties = new Properties();

    public BaseTest() {
        InputStream in =  Postmark.class.getClassLoader().getResourceAsStream(propertyFile);

        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Properties config() {
        return properties;
    }

    public ApiClient getDefaultApiClient() {
        return Postmark.getApiClient(config().getProperty("token"));
    }

    public AccountApiClient getDefaultAccountApiClient() {
        return Postmark.getAccountApiClient(config().getProperty("accountToken"));
    }
}
