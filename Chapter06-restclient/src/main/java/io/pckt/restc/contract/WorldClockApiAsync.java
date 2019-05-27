package io.pckt.restc.contract;

import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/json")
@RegisterRestClient(baseUri = WorldClockApiWithHeaders.BASE_URL)
public interface WorldClockApiAsync {
    String BASE_URL = "http://worldclockapi.com/api/json";

    @GET
    @Path("/utc/now")
    @Produces(MediaType.APPLICATION_JSON)
    CompletionStage<Now> utc();

    @GET
    @Path("{tz}/now")
    @Produces(MediaType.APPLICATION_JSON)
    CompletionStage<Now> tz(@PathParam("tz") String tz);
}
