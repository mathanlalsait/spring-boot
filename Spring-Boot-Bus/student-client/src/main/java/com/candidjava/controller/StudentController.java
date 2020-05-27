package com.candidjava.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RefreshScope
@RestController
public class StudentController
{
    @Value("${app.client-name}")
    private String clientName;

    @GetMapping("/client")
    public String getServiceName() {
        return "Client name [" + this.clientName + "]";
    }
}