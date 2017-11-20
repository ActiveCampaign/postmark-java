package base;

import com.wildbit.java.postmark.Postmark;
import com.wildbit.java.postmark.client.AccountApiClient;
import com.wildbit.java.postmark.client.ApiClient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import java.nio.file.*;

/**
 * Created by bash on 11/14/17.
 */
public class BaseTest {

    // Constants names for API tokens
    private enum DEFAULT_KEY_NAMES {
        API_TOKEN("POSTMARK_API_TOKEN"),
        ACCOUNT_TOKEN("POSTMARK_ACCOUNT_TOKEN");

        public final String value;
        DEFAULT_KEY_NAMES(String value) {
            this.value = value;
        }
    }

    private final String propertyFile = ".properties";
    public Properties properties;
    private final Path testResourcesPath = Paths.get("src/test/resources/");
    private final Path configFilePath = Paths.get("src/test/resources/" + propertyFile);

    public String defaultApiToken;
    public String defaultAccountToken;

    public BaseTest() {

        // Read configuration from property file
        if (Files.exists(configFilePath)) {
            initConfingFromFile();
            defaultApiToken = properties.getProperty(DEFAULT_KEY_NAMES.API_TOKEN.value);
            defaultAccountToken = properties.getProperty(DEFAULT_KEY_NAMES.ACCOUNT_TOKEN.value);
        }
        // read configuration from Environment variables
        else {
            Map<String, String> env = System.getenv();
            defaultApiToken = env.get(DEFAULT_KEY_NAMES.API_TOKEN.value);
            defaultAccountToken = env.get(DEFAULT_KEY_NAMES.ACCOUNT_TOKEN.value);
        }

    }

    public Properties config() {
        return properties;
    }

    public ApiClient getDefaultApiClient() {
        return Postmark.getApiClient(defaultApiToken);
    }

    public AccountApiClient getDefaultAccountApiClient() {
        return Postmark.getAccountApiClient(defaultAccountToken);
    }

    public String getDefaultFilePath() {
        return testResourcesPath.toString() + "/test.pdf";
    }

    private void initConfingFromFile() {

        InputStream in =  Postmark.class.getClassLoader().getResourceAsStream(propertyFile);
        properties = new Properties();

        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
