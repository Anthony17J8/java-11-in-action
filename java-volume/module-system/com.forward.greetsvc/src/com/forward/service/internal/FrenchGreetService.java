package com.forward.service.internal;

import com.forward.service.GreeterService;

public class FrenchGreetService implements GreeterService {

    @Override
    public String greet() {
        return "Bonjour";
    }
}
