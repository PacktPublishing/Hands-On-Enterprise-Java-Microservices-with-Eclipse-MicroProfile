package io.packt.sample.health;

import java.net.URI;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

/**
 * Validate the keycloak realm this service depends on as the health check
 */
@Health
@ApplicationScoped
public class KeycloakHealthCheck implements HealthCheck {
    @Inject
    @ConfigProperty(name = "keycloak.baseURL")
    String baseURL;
    @Inject
    @ConfigProperty(name = "keycloak.realmName")
    String realmName;

    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder builder = HealthCheckResponse.named("keycloak");
        checkKeycloakRealm(builder);
        return builder.build();
    }

    /**
     * Queries the configured keycloak realm using RestClient and the {@link KeycloakService} typed interface
     * @param builder - health check response builder
     */
    private void checkKeycloakRealm(HealthCheckResponseBuilder builder) {
        try {
            URI baseURI = URI.create(baseURL);
            System.out.printf("Checking keycloak(%s), baseURI: %s\n", realmName, baseURI);
            KeycloakService keycloakService = RestClientBuilder.newBuilder()
                    .baseUri(baseURI)
                    .build(KeycloakService.class);
            KeycloakRealm kcRealm = keycloakService.getRealm(realmName);
            builder.withData("realm", kcRealm.getRealm())
                    .withData("publicKey", kcRealm.getPublicKey())
                    .withData("accountService", kcRealm.getAccountService())
                    .withData("tokenService", kcRealm.getTokenService())
                    .up();
        } catch (Exception e) {
            e.printStackTrace();
            builder.withData("exception", e.getMessage())
                .down();
        }
    }
}
