package io.packt.sample.secure;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8081/demo2/secure")
@RegisterClientHeaders
public interface UserTimeZoneService {
    @GET
    @Path("/userTZ")
    @Produces(MediaType.TEXT_PLAIN)
    String getUserTZ();
}
