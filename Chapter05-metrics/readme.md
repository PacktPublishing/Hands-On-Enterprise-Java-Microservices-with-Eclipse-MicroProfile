# MicroProfile Metrics

## Building

Build the sources with a Thorntail server:

```bash
mvn install
```

## Running

After building the source and the server as a (so called) fat-jar, you
can run it via


```bash
$ java -jar target/metrics-thorntail.jar
```

Wait until the server has started. this is indicated by a line like this:

```
2019-02-18 12:54:02,595 INFO  [org.wildfly.swarm] (main) THORN99999: Thorntail is Ready
```

Then in a 2nd window you can query the metrics via


```bash
$ curl http://localhost:8080/metrics
```

Or open that URL with your browser.

To get a hold of the application metrics, first hit the endpoint(s)
a few times via

```bash
$ curl localhost:8080/book-metrics
```

and then get metrics (in JSON Format)

```
$ curl -HAccept:application/json http://localhost:8080/metrics/application
{
  "aCounter" : 4,   #<1>
  "aMeter" : {      #<2>
    "count": 4,
    "meanRate": 0.10647278508557566,
    "oneMinRate": 0.3639183958275802,
    "fiveMinRate": 0.5429024508215757,
    "fifteenMinRate": 0.5803296602892035
  },
  "aTimer" : {      #<3>
    "p50": 6356.0,
    "p75": 9329.0,
    "p95": 50041.0,
    "p98": 50041.0,
    "p99": 50041.0,
    "p999": 50041.0,
    "min": 4511.0,
    "mean": 15578.601623592564,
    "max": 50041.0,
    "stddev": 17951.99668265437,
    "count": 4,
    "meanRate": 0.1064829948785641,
    "oneMinRate": 0.3639183958275802,
    "fiveMinRate": 0.5429024508215757,
    "fifteenMinRate": 0.5803296602892035
  },
  "io.packt.metrics.RestHandler.aGauge" : 42,  #<4>
  "justACounter" : 8   #<5>
}
```

* <1> The defined counter
* <2> The defined meter
* <3> The defined timer
* <4> The defined gauge - `absolute` was set to `false`
* <5> The counter defined in code

You can also look at individual types of metrics (endpoints are relative to http://localhost:8080)

| Type | App-Endpoint | Metric-Endpoint |
| ---  | ---          |   ---           |
| Timer | /book-metrics/hello | /metrics/application/helloTime |
| Meter | /book-metrics/m | /metrics/application/getMetered |
| Counter | /book-metrics/c | /metrics/application/getCounted |
| Histogram | book-metrics/h | /metrics/application/aHistogram |


