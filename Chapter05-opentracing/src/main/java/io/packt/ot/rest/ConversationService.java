package io.packt.ot.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Traced
@ApplicationScoped
public class ConversationService {

    @Inject
    @RestClient
    private GreetingService greetingService;

    public String talk() {
        return greetingService.hello() + " -> " + greetingService.bonjour();
    }
}
