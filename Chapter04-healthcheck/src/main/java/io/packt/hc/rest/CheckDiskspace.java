package io.packt.hc.rest;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;

@Health
@ApplicationScoped
public class CheckDiskspace implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("diskspace")
                .withData("free", "780mb")
                .up()
                .build();
    }
}