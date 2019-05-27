package io.pckt.restc.contract;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/json")
@RegisterRestClient(baseUri = WorldClockApiWithHeaders.BASE_URL)
public interface WorldClockApiWithHeaders {
    static final String BASE_URL = "http://worldclockapi.com/api/json";

    default String lookupUserAgent() {
        Config config = ConfigProvider.getConfig();
        String userAgent = config.getValue("WorldClockApi.userAgent", String.class);
        if(userAgent == null) {
            userAgent = "MicroProfile Rest Client 1.2";
        }
        return userAgent;
    }

    @GET
    @Path("/utc/now")
    @Produces(MediaType.APPLICATION_JSON)
    @ClientHeaderParam(name = "User-Agent", value = "{lookupUserAgent}")
    Now utc();

    @GET
    @Path("{tz}/now")
    @Produces(MediaType.APPLICATION_JSON)
    @ClientHeaderParam(name = "User-Agent", value = "MicroProfile Rest Client 1.2")
    Now tz(@PathParam("tz") String tz);
}
