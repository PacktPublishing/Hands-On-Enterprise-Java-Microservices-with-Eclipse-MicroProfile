# MicroProfile OpenTracing

This example app demonstrates features of MicroProfile-OpenTracing

## Run Jaeger all-in-one distribution

```bash
docker run --rm -it --name jaeger \
  -p 5775:5775/udp \
  -p 6831:6831/udp \
  -p 6832:6832/udp \
  -p 5778:5778 \
  -p 16686:16686 \
  -p 14268:14268 \
  jaegertracing/all-in-one:1.12
```

Open browser at http://localhost:16686

## Compile and run the application
```bash
mvn clean package
java -jar target/opentracing-thorntail.jar
```

To create requests run:
```bash
curl localhost:8080/conversation
```
