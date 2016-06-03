package io.hbprotoss.thymeleaf.dialect.processor;

import io.hbprotoss.thymeleaf.service.UserService;
import io.hbprotoss.thymeleaf.util.TemplateUtil;
import org.springframework.web.context.WebApplicationContext;
import org.thymeleaf.context.IEngineContext;
import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.TemplateManager;
import org.thymeleaf.engine.TemplateModel;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.spring4.context.SpringContextUtils;
import org.thymeleaf.templatemode.TemplateMode;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by hbprotoss on 6/2/16.
 */
public class HeaderElementTagProcessor extends AbstractElementTagProcessor {
    private static final String TAG_NAME = "header";
    private static final int PRECEDENCE = 1000;

    public HeaderElementTagProcessor(String dialectPrefix) {
        super(
                TemplateMode.HTML, // This processor will apply only to HTML mode
                dialectPrefix,     // Prefix to be applied to name for matching
                TAG_NAME,          // Tag name: match specifically this tag
                true,              // Apply dialect prefix to tag name
                null,              // No attribute name: will match by tag name
                false,             // No prefix to be applied to attribute name
                PRECEDENCE);       // Precedence (inside dialect's own precedence)
    }

    @Override
    protected void doProcess(ITemplateContext context, IProcessableElementTag tag, IElementTagStructureHandler structureHandler) {
        // 需要从WebApplicationContext中获取模板内容
        final WebApplicationContext webCtx = (WebApplicationContext) SpringContextUtils.getApplicationContext(context);
        // 向渲染引擎传递变量
        final IEngineContext engineCtx = (IEngineContext) context;
        // 自定义service
        final UserService userService = (UserService) webCtx.getBean("userService");

        String template;
        try {
            template = TemplateUtil.getTemplate("templates/header.html", webCtx);
        } catch (IOException e) {
            throw new RuntimeException("Can not read template");
        }
        // 向引擎上下文中添加username变量
        engineCtx.setVariable("username", userService.getUsername());

        final TemplateManager templateManager = context.getConfiguration().getTemplateManager();
        final TemplateModel templateModel =
                templateManager.parseString(
                        context.getTemplateData(), template,
                        tag.getLine(), tag.getCol(),
                        null, // No need to force template mode
                        true);
        final StringWriter writer = new StringWriter();
        templateManager.process(templateModel, context, writer);
        // 可以考虑保留引用标签上的属性
        structureHandler.replaceWith(writer.toString(), false);
    }
}
