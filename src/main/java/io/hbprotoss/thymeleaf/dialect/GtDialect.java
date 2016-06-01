package io.hbprotoss.thymeleaf.dialect;

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
        return processors;
    }
}
