package io.packt.restc.services;

import java.net.URI;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.pckt.restc.contract.Now;
import io.pckt.restc.contract.WorldClockApi;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

@Path("/api")
@ApplicationScoped
public class WorldClockUser {
    @GET
    @Path("/now-utc")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCurrentDateTime() {
        WorldClockApi remoteApi = RestClientBuilder.newBuilder()
                .baseUri(URI.create(WorldClockApi.BASE_URL))
                .build(WorldClockApi.class);
        Now now = remoteApi.utc();
        return now.getCurrentDateTime();
    }
}
