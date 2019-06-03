
package com.packt.microprofile_book.metrics;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import org.eclipse.microprofile.metrics.Counter;
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

  @Inject
  @Metric(absolute = true)
  private Counter justACounter;

  @SuppressWarnings("unused")
  @Gauge(name = "aGauge", unit = MetricUnits.NONE)
  int myGauge() {
    return 42;
  }

  @GET
  @Counted(name="aCounter", monotonic = true, absolute = true)
  @Metered(name="aMeter", absolute = true)
  @Timed(  name="aTimer", absolute = true)
  public String triggerAllMetrics() {

    justACounter.inc(2);

    return "Yo!";

  }

}
