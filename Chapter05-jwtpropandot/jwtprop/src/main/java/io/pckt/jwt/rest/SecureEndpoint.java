package io.pckt.jwt.rest;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/jwt")
public class SecureEndpoint {
    @Inject
    JsonWebToken jwt;
    @Context
    private SecurityContext context;

    @GET
    @Path("/openHello")
    @Produces(MediaType.TEXT_PLAIN)
    @PermitAll
    public String openHello() {
        String user = jwt == null ? "anonymous" : jwt.getName();
        return "Hello[open] " + user;
    }
    @GET
    @Path("/secureHello")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("User")
    public String secureHello() {
        String user = jwt == null ? "anonymous" : jwt.getName();
        return "Hello[secure] " + user;
    }
}
