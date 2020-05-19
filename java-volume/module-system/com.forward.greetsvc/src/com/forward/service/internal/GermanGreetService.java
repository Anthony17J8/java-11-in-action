package com.forward.service.internal;

import com.forward.service.GreeterService;

public class GermanGreetService implements GreeterService {

    @Override
    public String greet() {
        return "Guten Tag!";
    }
}
