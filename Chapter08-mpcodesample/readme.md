# PacktBook Sample Application

## Quarking a generated MicroProfile project

This is a sample project that consists of 3 subprojects illustrating MicroProfile 2.2 features. We recommend that you
launch four shells on your computer and then run the various commands given in this
section in the indicated shell. Arrange the four shells in a 2x2 gride like the following:

| Col1  | Col2  |
| ------|-------|
| Docker| Web   |
| Svcs1 | Svcs2 |

When giveing a command we will refer to one of the 4 shells from the table:
* Docker
* Web
* Svcs1
* Svcs2

### Docker Shell Commands

This project depends on KeyCloak for the MP-JWT token generation. To launch Keycloak in a docker
container run:

```bash
docker run -d --name keycloak -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -p 8180:8180 -v `pwd`/packt-mp-realm.json:/config/quarkus-packt.json -it jboss/keycloak:6.0.1 -b 0.0.0.0 -Djboss.http.port=8180 -Dkeycloak.migration.action=import -Dkeycloak.migration.provider=singleFile -Dkeycloak.migration.file=/config/quarkus-packt.json -Dkeycloak.migration.strategy=OVERWRITE_EXISTING
```

This project also depends on Jaeger for the collection of the MP OpenTracing information. To launch
the Jaeger tracing system in a docker container run: 
```bash
docker run -d -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 -p 9411:9411 jaegertracing/all-in-one:latest
```

### Web Shell Command
Next, in the web shell, clone this project to your computer, cd to the web subdirectory and then running this
 command to exexute the web application in development mode:

`mvn clean package`

Once the build is finished, to run the web subproject jar, enter:

`java -jar target/sample-web-runner.jar`

Once application is up and running, point your browser to:
http://localhost:8080/index.html

### Svcs1 Shell Command
Next, in the Svcs1 shell, cd to the svcs1 subdirectory and then run this
 command to exexute the svcs1 image in development mode:

mvn compile quarkus:dev

Once application is up and running, point your browser to:

http://localhost:8080/index.html

### Svcs2 Shell Command
Next, in the Svcs2 shell, cd to the svcs2 subdirectory and then run this
command to build the svcs1 image:

`mvn clean package`

Once the build is finished, to run the svcs2 jar, enter:

`java -jar target/sample-svcs2-runner.jar`

### Compiling to native

To compile an image to native code, you need to have the [GraalVM](https://github.com/oracle/graal/releases) installed
and a GRAALVM_HOME environment variable set to the location of the GraalVM home.

Once you have GraalVM install, build the native executable by running the following from the command line
in either the web, svcs1 or svcs2 subprojects:

mvn package -Pnative

Once the compilation is finished, to run the executable, enter:

`./target/sample-web`

or

`./target/sample-svcs1`

or

`./target/sample-svcs2`

depending on which subproject you built.

## Testing the Endpoints
Use the tabs in the web app to access the URLs for the various services.
