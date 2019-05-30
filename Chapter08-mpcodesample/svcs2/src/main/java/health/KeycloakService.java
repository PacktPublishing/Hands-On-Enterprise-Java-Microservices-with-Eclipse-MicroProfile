package health;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://localhost:8180/auth")
public interface KeycloakService {
    @GET
    @Path("/realms/{realmName}")
    @Produces(MediaType.APPLICATION_JSON)
    KeycloakRealm getRealm(@PathParam("realmName") String realmName);
}
