package io.packt.sample.secure;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * A secured endpoint that provides access to the zoneinfo claim
 */
@Path("/protected")
@RequestScoped
public class ZoneInfoEndpoint {

    @Inject
    @Claim("zoneinfo")
    private String zoneinfo;
    @Inject
    JsonWebToken jwt;

    @GET
    @Path("/userTZ")
    @RolesAllowed("WorldClockSubscriber")
    @Produces(MediaType.TEXT_PLAIN)
    @Timed
    public String getSubscriberZoneInfo() {
        System.out.printf("Zoneinfo for %s: %s\n", jwt.getName(), zoneinfo);
        return zoneinfo;
    }
}
