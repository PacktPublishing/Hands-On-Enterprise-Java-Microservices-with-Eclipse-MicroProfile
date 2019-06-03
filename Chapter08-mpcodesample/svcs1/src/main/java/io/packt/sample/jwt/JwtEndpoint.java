package io.packt.sample.jwt;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.ClaimValue;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/jwt")
@DenyAll
@RequestScoped
public class JwtEndpoint {
    @Inject
    private JsonWebToken jwt;
    @Inject
    @Claim(standard = Claims.raw_token)
    private ClaimValue<String> jwtString;
    @Inject
    @Claim(standard = Claims.upn)
    private ClaimValue<String> upn;
    @Context
    private SecurityContext context;

    @GET
    @Path("/openHello")
    @Produces(MediaType.TEXT_PLAIN)
    @PermitAll
    public String openHello() {
        String user = jwt == null ? "anonymous" : jwt.getName();
        String upnClaim = upn != null ? upn.getValue() : "no-upn";
        return String.format("Hello[open] user=%s, upn=%s", user, upnClaim);
    }

    @GET
    @Path("/secureHello")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("user")
    public String secureHello() {
        String user = jwt == null ? "anonymous" : jwt.getName();
        String scheme = context.getAuthenticationScheme();
        boolean isUserInRole = context.isUserInRole("PacktMPUser");
        return String.format("Hello[secure] user=%s, upn=%s, scheme=%s, isUserInRole(PacktMPUser)=%s", user, upn.getValue(), scheme, isUserInRole);
    }
}
