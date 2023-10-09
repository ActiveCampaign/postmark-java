package integration;

import base.BaseTest;
import com.postmarkapp.postmark.client.AccountApiClient;
import com.postmarkapp.postmark.client.data.model.data_removal.DataRemoval;
import com.postmarkapp.postmark.client.data.model.data_removal.DataRemovalStatus;
import com.postmarkapp.postmark.client.data.model.data_removal.DataRemovalStatusTypes;
import com.postmarkapp.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by bash on 11/14/17.
 */
public class DataRemovalTest extends BaseTest {
    AccountApiClient client = getDefaultAccountApiClient();
    @Test
    void requestDataRemoval() throws PostmarkException, IOException {
        DataRemoval dataRemoval = new DataRemoval("requestedBy@example.com",
                "requestedFor@example.com", false);

        DataRemovalStatus dataRemovalStatus = client.requestDataRemoval(dataRemoval);
        assertNotNull(dataRemovalStatus.getId());
        assertEquals(dataRemovalStatus.getStatus(), DataRemovalStatusTypes.Pending);
    }

    @Test
    void getDataRemovalStatus() throws PostmarkException, IOException {
        DataRemoval dataRemoval = new DataRemoval("requestedBy@example.com",
                "requestedFor@example.com", false);

        Integer dataRemovalStatusId = client.requestDataRemoval(dataRemoval).getId();
        DataRemovalStatus dataRemovalStatus = client.getDataRemovalStatus(dataRemovalStatusId);
        assertEquals(dataRemovalStatus.getId(), dataRemovalStatusId);
    }
}
