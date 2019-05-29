package io.packt.sample.metric;

import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.Random;

@Path("/metric")
@ApplicationScoped //Required for @Gauge
public class MetricController {

    @Inject
    @Metric(name = "endpoint_counter")
    private Counter counter;

    @Path("timed")
    @Timed(name = "timed-request")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String timedRequest() {
        long start = System.currentTimeMillis();
        // Demo, not production style
        int wait = new Random().nextInt(1000);
        try {
            Thread.sleep(wait);
        } catch (InterruptedException e) {
            // Demo
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long delay = end - start;

        doIncrement();
        long count = getCustomerCount();
        return String.format("MetricController#timedRequest, delay[0-1000]=%d, count=%d", delay, count);
    }

    @Path("increment")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public long doIncrement() {
        counter.inc();
        return counter.getCount();
    }

    @Gauge(name = "counter_gauge", unit = MetricUnits.NONE)
    private long getCustomerCount() {
        return counter.getCount();
    }
}
