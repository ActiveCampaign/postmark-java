package integration;

import base.BaseTest;
import com.postmarkapp.postmark.client.ApiClient;
import com.postmarkapp.postmark.client.Parameters;
import com.postmarkapp.postmark.client.data.model.templates.*;
import com.postmarkapp.postmark.client.exception.PostmarkException;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.HashMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    void createTemplate_should_work_with_utf_8() throws PostmarkException, IOException {

        String utf8String = "test html with unicode symbols: € Ä Æ ©";
        String templateName = "name";

        TemplateContent templateContent = new TemplateContent();
        templateContent.setHtmlBody(utf8String);
        templateContent.setTextBody("test text");
        templateContent.setName(templateName);
        templateContent.setSubject("subject");

        BaseTemplate response = client.createTemplate(templateContent);
        assertEquals(response.getName(),templateName);

        Template template = client.getTemplate(response.getTemplateId());
        assertEquals(utf8String, template.getHtmlBody());

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
