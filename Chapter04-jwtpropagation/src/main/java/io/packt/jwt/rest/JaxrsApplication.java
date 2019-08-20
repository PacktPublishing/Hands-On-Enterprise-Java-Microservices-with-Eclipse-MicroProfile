package io.packt.jwt.rest;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.auth.LoginConfig;

@LoginConfig(authMethod = "MP-JWT", realmName = "Packt")
@ApplicationPath("/")
public class JaxrsApplication extends Application {
}
