package io.packt.hc.rest;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@Health
@ApplicationScoped
public class ServiceCheck implements HealthCheck {
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("service-check")
                .withData("port", 12345)
                .withData("isSecure", true)
                .withData("hostname", "service.jboss.com")
                .up()
                .build();
    }
}
