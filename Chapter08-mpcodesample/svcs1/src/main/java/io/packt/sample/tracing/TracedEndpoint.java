package io.packt.sample.tracing;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.opentracing.Traced;

@ApplicationScoped
@Path("/traced")
public class TracedEndpoint {
    @GET
    @Path("/randomDelay")
    @Produces(MediaType.TEXT_PLAIN)
    @Traced(operationName = "TracedEndpoint#demoRandomDelay")
    public String randomDelay() {
        long start = System.currentTimeMillis();
        // 0-5 seconds random sleep
        long sleep = Math.round(Math.random() * 5000);
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        return String.format("TracedEndpoint.randomDelay[0-5000], elapsed=%d", (end - start));
    }

    @GET
    @Path("/untraced")
    @Produces(MediaType.TEXT_PLAIN)
    @Traced(false)
    public String untraced() {
        return "No tracing";
    }
}
