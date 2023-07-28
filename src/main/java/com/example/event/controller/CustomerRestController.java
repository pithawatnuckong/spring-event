package com.example.event.controller;

import com.example.event.model.event.CustomerEventModel;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    private final ApplicationEventPublisher publisher;

    public CustomerRestController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping
    public void testEvent() {
        publisher.publishEvent(new CustomerEventModel("001", "Hello"));
    }
}
