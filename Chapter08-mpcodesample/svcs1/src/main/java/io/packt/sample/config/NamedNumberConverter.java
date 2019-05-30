package io.packt.sample.config;

import org.eclipse.microprofile.config.spi.Converter;

/**
 * Example custom converter. Not working in Quarkus 13.2.
 */
public class NamedNumberConverter implements Converter<NamedNumber> {
    /**
     * Parses an assignment type of expression into a name and number value
     * @param value name=Number expression
     * @return NamedNumber instance
     */
    @Override
    public NamedNumber convert(String value) {
        String[] parts = value.split("=");
        return null;
    }
}
