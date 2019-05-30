package io.packt.sample;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.auth.LoginConfig;

import javax.annotation.security.DeclareRoles;

import javax.enterprise.event.Observes;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/demo2")
@LoginConfig(authMethod = "MP-JWT", realmName = "quarkus-quickstart")
public class SecureRestApplication extends Application {
    void onStart(@Observes StartupEvent event) {
        System.out.printf("onStart, event=%s%n", event);
    }

    void onStop(@Observes ShutdownEvent event) {
        System.out.printf("onStop, event=%s%n", event);
    }
}

