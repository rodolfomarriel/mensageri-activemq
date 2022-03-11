package com.example.activemq.consumer.jms;

import com.example.activemq.consumer.model.Person;
import com.example.activemq.consumer.repositories.PersonRepository;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    private List<Person> persons = new ArrayList();
    private final PersonRepository personRepository;

    @JmsListener(
            destination = "${activemq.name}"
    )
    public void listen(String mensagem) {
        System.out.println(mensagem);
        new Person();

        try {
            Gson gson = new Gson();
            Person person = (Person)gson.fromJson(mensagem, Person.class);
            this.personRepository.save(person);
        } catch (Exception var4) {
        }

    }

    public Consumer(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}