package com.forward.greet.internal;

import com.forward.greet.Greeter;

/**
 * Compile:
 * javac com.forward.greetings/src/module-info.java \
 * > com.forward.greetings/src/com/forward/greet/Greeter.java \
 * > com.forward.greetings/src/com/forward/greet/internal/GreeterImpl.java
 */

public class GreeterImpl implements Greeter {

    @Override
    public String greet(String subject) {
        return "Hello, " + subject + "!";
    }
}
