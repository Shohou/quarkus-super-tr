package org.acme;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @Inject
    SomeService someService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        String field = someService.doSomething();
        return "Hello from RESTEasy Reactive - " + field;
    }
}
