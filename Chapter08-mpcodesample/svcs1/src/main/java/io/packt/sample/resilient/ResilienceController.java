package io.packt.sample.resilient;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/resilience")
@ApplicationScoped
public class ResilienceController {

    @Fallback(fallbackMethod = "fallback") // better use FallbackHandler
    @Timeout(500)
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String checkTimeout() {
        try {
            Thread.sleep(700L);
        } catch (InterruptedException e) {
            //
        }
        return "Never from normal processing";
    }

    public String fallback() {
        return "Fallback answer due to timeout";
    }
}
