package io.packt.sample.health;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

import javax.enterprise.context.ApplicationScoped;

@Health
@ApplicationScoped
public class ServiceHealthCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("service-check")
                .withData("port", 12345)
                .withData("isSecure", true)
                .withData("hostname", "service.jboss.com")
                .up()
                .build();
    }
}
