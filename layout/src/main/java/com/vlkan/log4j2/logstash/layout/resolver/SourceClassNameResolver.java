package com.vlkan.log4j2.logstash.layout.resolver;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.TextNode;
import org.apache.logging.log4j.core.LogEvent;

public class SourceClassNameResolver implements TemplateResolver {

    private static final SourceClassNameResolver INSTANCE = new SourceClassNameResolver();

    private SourceClassNameResolver() {
        // Do nothing.
    }

    public static SourceClassNameResolver getInstance() {
        return INSTANCE;
    }

    @Override
    public String getName() {
        return "sourceClassName";
    }

    @Override
    public JsonNode resolve(TemplateResolverContext context, LogEvent logEvent) {
        if (!context.isLocationInfoEnabled() || logEvent.getSource() == null) {
            return null;
        }
        String sourceClassName = logEvent.getSource().getClassName();
        return new TextNode(sourceClassName);
    }

}
