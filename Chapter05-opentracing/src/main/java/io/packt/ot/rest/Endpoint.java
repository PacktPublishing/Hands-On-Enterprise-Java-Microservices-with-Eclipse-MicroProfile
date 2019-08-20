package io.packt.ot.rest;

import io.opentracing.Tracer;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.opentracing.Traced;

@Path("/")
public class Endpoint {

    @Inject
    private Tracer tracer;

    @Inject
    private ConversationService conversationService;

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(@HeaderParam("user-agent") String userAgent) {
        tracer.activeSpan().setTag("user-agent", userAgent);
        return "hello";
    }

    @GET
    @Path("/bonjour")
    @Produces(MediaType.TEXT_PLAIN)
    @Traced(operationName = "bonjour")
    public String bonjour() {
        return "bonjour";
    }

    @GET
    @Path("/conversation")
    @Produces(MediaType.TEXT_PLAIN)
    public String conversation() {
        return conversationService.talk();
    }
}
