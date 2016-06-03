package io.hbprotoss.thymeleaf.util;

import com.google.common.io.CharStreams;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by hbprotoss on 6/3/16.
 */
public class TemplateUtil {
    public static String getTemplate(String filename, WebApplicationContext context) throws IOException {
        InputStream stream = context.getServletContext().getResourceAsStream("WEB-INF/" + filename);
        return CharStreams.toString(new InputStreamReader(stream));
    }
}
