package com.forward.greet.internal;

import com.forward.greet.Greeter;

/**
 * Compile:
 * javac com.forward.greetings/src/module-info.java \
 * > com.forward.greetings/src/com/forward/greet/Greeter.java \
 * > com.forward.greetings/src/com/forward/greet/internal/GreeterImpl.java
 *
 * CREATE MODULAR Jar file:
 * Compile to one directory with module-info file:
 * javac -d out/com.forward.greetings $(find com.forward.greetings -name *.java)
 * jar -cvf com.forward.greetings.jar -C out/com.forward.greetings .
 *    create jar file with name              from              locate to
 */

public class GreeterImpl implements Greeter {

    @Override
    public String greet(String subject) {
        return "Hello, " + subject + "!";
    }
}
