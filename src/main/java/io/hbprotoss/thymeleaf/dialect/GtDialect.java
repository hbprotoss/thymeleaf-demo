package io.hbprotoss.thymeleaf.dialect;

import io.hbprotoss.thymeleaf.dialect.processor.EchoAttributeTagProcessor;
import io.hbprotoss.thymeleaf.dialect.processor.FooterElementTagProcessor;
import io.hbprotoss.thymeleaf.dialect.processor.HeaderElementTagProcessor;
import io.hbprotoss.thymeleaf.dialect.processor.NavElementTagProcessor;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hbprotoss on 6/1/16.
 */
public class GtDialect extends AbstractProcessorDialect {
    protected GtDialect() {
        super("Great Tao Dialect", "gt", 1000);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<>();
        processors.add(new EchoAttributeTagProcessor(dialectPrefix));
        processors.add(new HeaderElementTagProcessor(dialectPrefix));
        processors.add(new FooterElementTagProcessor(dialectPrefix));
        processors.add(new NavElementTagProcessor(dialectPrefix));
        return processors;
    }
}
