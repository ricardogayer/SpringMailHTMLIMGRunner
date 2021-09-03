package com.mwave.email;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.util.Map;

@Service
public class EmailTemplateService {

    private final Configuration configuration;

    public EmailTemplateService(Configuration configuration) {
        this.configuration = configuration;
    }

    public String getCorpoEmail(Map<String, Object> data, String templateName) throws IOException, TemplateException {
        Template template = configuration.getTemplate(templateName);
        return FreeMarkerTemplateUtils.processTemplateIntoString(template, data);
    }

}