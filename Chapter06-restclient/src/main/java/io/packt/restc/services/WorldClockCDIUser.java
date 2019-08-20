package io.packt.restc.services;

import io.packt.restc.contract.Now;
import io.packt.restc.contract.WorldClockApi;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
@Path("/cdi")
public class WorldClockCDIUser {
    @Inject
    @RestClient
    WorldClockApi remoteApi;

    @GET
    @Path("/now-utc")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCurrentDateTime() {
        Now now = remoteApi.utc();
        return now.getCurrentDateTime();
    }

}
