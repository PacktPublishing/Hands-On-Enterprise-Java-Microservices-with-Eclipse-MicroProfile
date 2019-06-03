package io.packt.sample;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.auth.LoginConfig;
import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

import javax.enterprise.event.Observes;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 */
@ApplicationPath("/demo1")
@LoginConfig(authMethod = "MP-JWT", realmName = "quarkus-quickstart")
@OpenAPIDefinition(
    info = @Info(
            title = "Quarkus MicroProfile 2.2 Extensions Demo",
            version = "1.0",
            contact = @Contact(
                    name = "QUARKUS - COMMUNITY",
                    url = "https://quarkus.io/community/",
                    email = "quarkus-dev+subscribe@googlegroups.com"),
            license = @License(
                    name = "Apache 2.0",
                    url = "http://www.apache.org/licenses/LICENSE-2.0.html")
    ),
    servers = {
                @Server(url = "http://localhost:8081/", description = "svcs1 host"),
                @Server(url = "http://localhost:8082/", description = "svcs2 host")
        },
    externalDocs = @ExternalDocumentation(url="http://microprofile.io", description = "Eclipse MicroProfile Homepage")
)
public class DemoRestApplication extends Application {
    void onStart(@Observes StartupEvent event) {
        System.out.printf("DemoRestApplication.onStart, event=%s%n", event);
    }

    void onStop(@Observes ShutdownEvent event) {
        System.out.printf("DemoRestApplication.onStop, event=%s%n", event);
    }
}
