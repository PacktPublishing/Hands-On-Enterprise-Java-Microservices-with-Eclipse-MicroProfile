package io.packt.sample.config;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Examples of config injection and API usage
 */
@Path("/config")
@RequestScoped
public class ConfigTestController {

    @Inject
    @ConfigProperty(name = "injected.value")
    String injectedValue;
    @Inject
    @ConfigProperty(name = "injected.piValue", defaultValue = "pi5=3.14159")
    Double piValue;

    @Path("/injected")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getInjectedConfigValue() {
        return String.format("Config value as Injected by CDI: '%s'", injectedValue);
    }

    @Path("/injectedPi")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getInjectedPiValue() {
        return String.format("Injected Pi value: '%.10f'", piValue.doubleValue());
    }

    @Path("/lookup")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getLookupConfigValue() {
        Config config = ConfigProvider.getConfig();
        String value = config.getValue("lookup.value", String.class);
        return String.format("Config value via API lookup: '%s'", value);
    }
}
