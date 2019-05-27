package io.pckt.restc.contract;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/json")
@RegisterRestClient(baseUri = WorldClockApi.BASE_URL)
public interface WorldClockApi {
    static final String BASE_URL = "http://worldclockapi.com/api/json";

    @GET
    @Path("/utc/now")
    @Produces(MediaType.APPLICATION_JSON)
    Now utc();

    @GET
    @Path("{tz}/now")
    @Produces(MediaType.APPLICATION_JSON)
    Now tz(@PathParam("tz") String tz);
}
