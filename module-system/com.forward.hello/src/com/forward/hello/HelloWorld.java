package com.forward.hello;

import com.forward.greet.Greeter;

/**
 * javac - p greetings/src hello/src/module-info.java \
 * > hello/src/com/forward/hello/HelloWorld.java
 *
 * java -p com.forward.greetings:com.forward.hello -m com.forward.hello/com.forward.hello.HelloWorld
 */
public class HelloWorld {
    public static void main(String[] args) {
        Greeter greeter = Greeter.getInstance();
        System.out.println(greeter.greet("Modular world"));
    }
}
