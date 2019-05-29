package io.packt.sample.health;

import java.io.File;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;

@Health
@ApplicationScoped
public class CheckDiskspace implements HealthCheck {
    @Inject
    @ConfigProperty(name = "health.pathToMonitor")
    String pathToMonitor;
    @Inject
    @ConfigProperty(name = "health.freeSpaceThreshold")
    long freeSpaceThreshold;

    @Override
    public HealthCheckResponse call() {
        HealthCheckResponseBuilder builder = HealthCheckResponse.named("diskspace");
        checkDiskspace(builder);
        return builder.build();
    }

    private void checkDiskspace(HealthCheckResponseBuilder builder) {
        File root = new File(pathToMonitor);
        long usableSpace = root.getUsableSpace();
        long freeSpace = root.getFreeSpace();
        long pctFree = 0;
        if (usableSpace > 0) {
            pctFree = (100 * usableSpace) / freeSpace;
        }
        builder.withData("path", root.getAbsolutePath())
                .withData("exits", root.exists())
                .withData("usableSpace", usableSpace)
                .withData("freeSpace", freeSpace)
                .withData("pctFree", pctFree)
                .state(freeSpace >= freeSpaceThreshold);
    }
}