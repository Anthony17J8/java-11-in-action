package com.forward.greet;

import com.forward.greet.internal.GreeterImpl;

public interface Greeter {

    static Greeter getInstance() {
        return new GreeterImpl();
    }

    String greet(String subject);
}
