package com.example.activemq.producer.jms;

import com.example.activemq.producer.model.Person;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    private final JmsTemplate jmsTemplate;
    @Value("${activemq.name}")
    private String destinationQueue;

    public void send(Person person) {
        Gson gson = new Gson();
        String jsonPerson = gson.toJson(person);
        this.jmsTemplate.convertAndSend(this.destinationQueue, jsonPerson);
    }

    public Producer(final JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }
}