package integration;

import base.BaseTest;
import com.wildbit.java.postmark.client.ApiClient;
import com.wildbit.java.postmark.client.Parameters;
import com.wildbit.java.postmark.client.data.model.bounces.Bounce;
import com.wildbit.java.postmark.client.data.model.bounces.BounceDump;
import com.wildbit.java.postmark.client.data.model.bounces.Bounces;
import com.wildbit.java.postmark.client.data.model.bounces.DeliveryStats;
import com.wildbit.java.postmark.client.data.model.templates.*;
import com.wildbit.java.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;



import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by bash on 11/14/17.
 */
public class TemplateTest extends BaseTest {

    ApiClient client = getDefaultApiClient();

    @Test
    void validateHtmlBody() throws PostmarkException, IOException {
        TemplateToValidate templateToValidate = new TemplateToValidate();
        templateToValidate.setSubject("{{#company}}{{name}}{{/company}} {{subjectHeadline}}");
        templateToValidate.setHtmlBody("{{#company}}{{name}}{{/company}} {{subjectHeadline}}");
        templateToValidate.setTextBody("{{#company}}{{phone}}{{/company}}{{#each person}} {{name}} {{/each}}");

        HashMap renderModel = new HashMap<String, Object>();
        renderModel.put("userName", "bobby joe");
        templateToValidate.setTestRenderModel(renderModel);

        TemplateValidation validation = client.validateTemplate(templateToValidate);
        assertEquals(validation.getHtmlBody().getContentIsValid(), true);
        assertEquals(validation.getHtmlBody().getValidationErrors().size(),0);
        assertNotNull(validation.getHtmlBody().getRenderedContent());

    }

    @Test
    void validateTextBody() throws PostmarkException, IOException {
        TemplateToValidate templateToValidate = new TemplateToValidate();
        templateToValidate.setSubject("{{#company}}{{name}}{{/company}} {{subjectHeadline}}");
        templateToValidate.setHtmlBody("{{#company}}{{name}}{{/company}} {{subjectHeadline}}");
        templateToValidate.setTextBody("{{#company}}{{phone}}{{/company}}{{#each person}} {{name}} {{/each}}");

        HashMap renderModel = new HashMap<String, Object>();
        renderModel.put("userName", "bobby joe");
        templateToValidate.setTestRenderModel(renderModel);

        TemplateValidation validation = client.validateTemplate(templateToValidate);
        assertEquals(validation.getTextBody().getContentIsValid(), true);
        assertEquals(validation.getTextBody().getValidationErrors().size(),0);
        assertNotNull(validation.getTextBody().getRenderedContent());
    }

    @Test
    void createTemplate() throws PostmarkException, IOException {

        String templateName = "name";

        TemplateContent templateContent = new TemplateContent();
        templateContent.setHtmlBody("test html");
        templateContent.setTextBody("test text");
        templateContent.setName(templateName);
        templateContent.setSubject("subject");

        BaseTemplate response = client.createTemplate(templateContent);
        assertEquals(response.getName(),templateName);

        Integer id = response.getTemplateId();
        client.deleteTemplate(id);

    }

    @Test
    void deleteTemplate() throws PostmarkException, IOException {
        String templateName = "deleteName";

        TemplateContent templateContent = new TemplateContent();
        templateContent.setHtmlBody("test html");
        templateContent.setTextBody("test text");
        templateContent.setName(templateName);
        templateContent.setSubject("subject");

        BaseTemplate response = client.createTemplate(templateContent);
        Integer id = response.getTemplateId();
        String stringResponse = client.deleteTemplate(id);
        assertNotNull(stringResponse);

    }

    @Test
    void list() throws PostmarkException, IOException {
        Templates templates = client.getTemplates(Parameters.init().build("offset", 0).build("count", 4));
        assertNotNull(templates.getTotalCount());
    }

}
