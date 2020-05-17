package com.forward.hello;

import com.forward.greet.Greeter;

/**
 * javac - p greetings/src hello/src/module-info.java \
 * > hello/src/com/forward/hello/HelloWorld.java
 *
 * java -p com.forward.greetings:com.forward.hello -m com.forward.hello/com.forward.hello.HelloWorld
 *
 * CREATE MODULAR Jar file:
 *  javac -p com.forward.greetings.jar \
 * > -d out/com.forward.hello $(find com.forward.hello -name *.java)
 *
 * jar -c -v -f com.forward.hello.jar -e com.forward.hello.HelloWorld -C out/com.forward.hello .
 * java -p com.forward.greetings.jar:com.forward.hello.jar -m com.forward.hello
 */
public class HelloWorld {
    public static void main(String[] args) {
        Greeter greeter = Greeter.getInstance();
        System.out.println(greeter.greet("Modular world"));
    }
}
