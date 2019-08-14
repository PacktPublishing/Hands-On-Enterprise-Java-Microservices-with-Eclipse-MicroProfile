package io.pckt.ot.rest;

import java.util.Set;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;

@Path("/jwt")
@DenyAll
public class InjectionExampleEndpoint {
    @Inject
    @Claim(standard = Claims.groups)
    Set<String> rolesSet;
    @Inject
    @Claim(standard = Claims.iss)
    String issuer;

    @Inject
    @Claim(standard = Claims.groups)
    JsonArray rolesAsJson;
    @Inject
    @Claim(standard = Claims.iss)
    JsonString issuerAsJson;

    // Custom claims as JsonValue types
    @Inject
    @Claim("customString")
    JsonString customString;
    @Inject
    @Claim("customInteger")
    JsonNumber customInteger;
    @Inject
    @Claim("customDouble")
    JsonNumber customDouble;
    @Inject
    @Claim("customObject")
    JsonObject customObject;

    @GET
    @Path("/printClaims")
    @RolesAllowed("Tester")
    public String printClaims() {
        StringBuilder reply = new StringBuilder();
        reply.append("+++ Standard claims as primitive types\n");
        reply.append("rolesSet=");
        reply.append(rolesSet);
        reply.append('\n');
        reply.append("issuer=");
        reply.append(issuer);
        reply.append('\n');
        reply.append("+++ Standard claims as JSON types\n");
        reply.append("rolesAsJson=");
        reply.append(rolesAsJson);
        reply.append('\n');
        reply.append("issuerAsJson=");
        reply.append(issuerAsJson);
        reply.append('\n');
        reply.append("+++ Custom claim JSON types\n");
        reply.append("customString=");
        reply.append(customString);
        reply.append('\n');
        reply.append("customInteger=");
        reply.append(customInteger);
        reply.append('\n');
        reply.append("customDouble=");
        reply.append(customDouble);
        reply.append('\n');
        reply.append("customObject=");
        reply.append(customObject);
        reply.append('\n');

        return reply.toString();
    }
}
