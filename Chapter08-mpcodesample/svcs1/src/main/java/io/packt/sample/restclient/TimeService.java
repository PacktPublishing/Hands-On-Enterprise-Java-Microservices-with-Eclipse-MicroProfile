package io.packt.sample.restclient;

import java.net.URI;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 * Access the public worldclockapi UTC time using RestClient
 */
@Path("/time")
@ApplicationScoped
public class TimeService {
    @Inject
    @RestClient
    WorldClockApi clockApi;
    @Inject
    @ConfigProperty(name = "restclient.targetBaseUri", defaultValue = "http://localhost:8082/demo2")
    String targetBaseUri;

    @GET
    @Path("/now")
    @Produces(MediaType.APPLICATION_JSON)
    @Tag(name = "time", description = "time service methods")
    @ExternalDocumentation(description = "Basic World Clock API Home.",
            url = "http://worldclockapi.com/")
    @Operation(summary = "Queries the WorldClockApi using the MP-RestClient",
            description = "Uses the WorldClockApi type proxy injected by the MP-RestClient to access the worldclockapi.com service")
    public Now utc() {
        return clockApi.utc();
    }

    @GET
    @Path("/proxyUserTZ")
    @Produces(MediaType.APPLICATION_JSON)
    public Now proxyUserTZ() {
        UserTimeService remoteApi = RestClientBuilder.newBuilder()
                .baseUri(URI.create(targetBaseUri))
                .build(UserTimeService.class);
        return remoteApi.userNow();
    }
}
