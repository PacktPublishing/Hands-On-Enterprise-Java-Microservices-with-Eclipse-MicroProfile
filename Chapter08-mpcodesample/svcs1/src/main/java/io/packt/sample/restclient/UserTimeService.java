package io.packt.sample.restclient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8081/demo2/protected")
@RegisterClientHeaders
@Path("/time")
public interface UserTimeService {
    @GET
    @Path("/userNow")
    @Produces(MediaType.APPLICATION_JSON)
    public Now userNow();
}
