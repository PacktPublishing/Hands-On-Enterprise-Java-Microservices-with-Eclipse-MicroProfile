
package io.packt.metrics;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.Histogram;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.metrics.annotation.Timed;

/**
 * @author Heiko W. Rupp
 */
@Path("/")
@ApplicationScoped
public class RestHandler {

  @GET
  @Path("/hello")
  @Timed(name="helloTime", absolute = true, description = "Timing of the Hello call",
         tags={"type=timer","app=shop"})
  public String getHelloTimed() {
    try {
      Thread.sleep((long) (Math.random()*200.0));
    } catch (InterruptedException e) {
       // We don't care if the sleep is interrupted.
    }
    return "Hello World";
  }

  @SuppressWarnings("unused")
  @Gauge(name = "aGauge", unit = MetricUnits.NONE)
  int myGauge() {
    return 42;
  }

  @Inject
  @Metric(absolute = true)
  private Counter justACounter;

  @GET
  @Counted(name="aCounter", monotonic = true, absolute = true)
  @Metered(name="aMeter", absolute = true)
  @Timed(  name="aTimer", absolute = true)
  public String triggerAllMetrics() {

    justACounter.inc(2);

    return "Yo!";

  }

  @GET
  @Path("/m")
  @Metered(absolute = true)
  public String getMetered() {
    return "Metered called";
  }


  @GET
  @Path("/c")
  @Counted(monotonic = true, absolute = true)
  public String getCounted() {
    return "Counted called";
  }

  @Inject
  @Metric(absolute = true)
  private Histogram aHistogram;

  @GET
  @Path("/h")
  public String getHistogram() {
    aHistogram.update((int) (Math.random() * 10.0));
    return "Histogram called";
  }



}
