package io.packt.restc.services;

import io.packt.restc.contract.Now;
import io.packt.restc.contract.WorldClockApiAsync;
import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
@Path("/cdi-async")
public class WorldClockCDIAsyncUser {
    @Inject
    @RestClient
    WorldClockApiAsync remoteApi;

    @GET
    @Path("/now-utc")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getCurrentDateTime() {
        CompletionStage<Now> nowCS = remoteApi.utc();
        Now now = null;
        try {
            now = nowCS.toCompletableFuture().get();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Failed to : " + e.getMessage())
                    .build();
        }
        return Response.ok(now.getCurrentDateTime()).build();
    }

}
