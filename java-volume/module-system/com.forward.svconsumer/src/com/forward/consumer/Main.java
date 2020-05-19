package com.forward.consumer;

import com.forward.service.GreeterService;

import java.util.ServiceLoader;

/**
 * 1. Compile classes into com.forward.greetsvc module
 * javac com.forward.greetsvc/src/module-info.java \
 * > com.forward.greetsvc/src/com/forward/service/GreeterService.java \
 * > com.forward.greetsvc/src/com/forward/service/internal/*.java
 * <p>
 * 2. Compile classes into com.forward.svconsumer module
 * javac -p com.forward.greetsvc/src com.forward.svconsumer/src/module-info.java \
 * > com.forward.svconsumer/src/com/forward/consumer/Main.java
 * <p>
 * 3. Run Main method
 * java -p com.forward.greetsvc:com.forward.svconsumer -m com.forward.svconsumer/com.forward.consumer.Main
 */
public class Main {

    public static void main(String[] args) {
        ServiceLoader<GreeterService> greeterLoader = ServiceLoader.load(GreeterService.class);
        for (GreeterService service : greeterLoader) {
            System.out.println(service.greet());
        }
    }
}
