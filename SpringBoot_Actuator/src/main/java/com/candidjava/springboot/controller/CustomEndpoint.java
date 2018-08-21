package com.candidjava.springboot.controller;

//import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.actuate.endpoint.EndpointFilter;
import org.springframework.stereotype.Component;

@Component
public class CustomEndpoint implements Endpoint<String>{
    @Override
    public String getId() {
        return "youtube";
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isSensitive() {
        return false;
    }

    @Override
    public String invoke() {
        return "Hello Youtube";
}
}
