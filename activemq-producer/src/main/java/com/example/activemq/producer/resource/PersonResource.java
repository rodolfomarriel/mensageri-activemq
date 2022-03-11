package com.example.activemq.producer.resource;

import com.example.activemq.producer.jms.Producer;
import com.example.activemq.producer.model.Person;
import javax.jms.JMSException;
import javax.naming.NamingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonResource {
    private final Producer producer;

    @GetMapping({"/"})
    public String index() {
        return "index.html";
    }

    @GetMapping({"/cadastra-pessoas"})
    private String cadastraPessoas(Model model) {
        return "cadastra-pessoas.html";
    }

    @PostMapping({"salvar"})
    public String save(@RequestParam("name") String name, @RequestParam("age") int age, Model model) throws JMSException, NamingException {
        Person person = Person.builder().name(name).age(age).build();
        this.producer.send(person);
        return "/cadastra-pessoas";
    }

    public PersonResource(final Producer producer) {
        this.producer = producer;
    }
}
