package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SomeService extends SomeAbstractService {

    @Override
    public String doSomething() {
        System.out.println("SomeService.doSomething()");
        return super.doSomething();
    }
}
