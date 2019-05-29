package io.packt.sample.secure;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/time")
@ApplicationScoped
public class
TimeService {
    @Inject
    @RestClient
    WorldClockApi clockApi;
    @Inject
    @RestClient
    UserTimeZoneService userTimeZone;

    @GET
    @Path("/userNow")
    @Produces(MediaType.APPLICATION_JSON)
    public Now userNow() {
        String tz = userTimeZone.getUserTZ();
        Now userTime = clockApi.tz(tz);
        System.out.printf("TimeService.userNow: %s\n", userTime);
        return userTime;
    }
}
