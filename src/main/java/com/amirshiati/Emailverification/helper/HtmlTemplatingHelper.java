package com.amirshiati.Emailverification.helper;


import com.amirshiati.Emailverification.config.HtmlTemplateConfig;
import com.x5.template.Chunk;
import com.x5.template.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HtmlTemplatingHelper {

    private final HtmlTemplateConfig htmlTemplateConfig;

    @Autowired
    public HtmlTemplatingHelper(HtmlTemplateConfig htmlTemplateConfig) {
        this.htmlTemplateConfig = htmlTemplateConfig;
    }

    public String addCodeToHtml(String code) {
        String templatePath = htmlTemplateConfig.getPath();
        Theme theme = new Theme(templatePath, "");

        Chunk c = theme.makeChunk(htmlTemplateConfig.getFileName());
        c.set(htmlTemplateConfig.getVariableName(), code);

        return c.toString();
    }
}
