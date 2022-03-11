package com.example.activemq.consumer.repositories;

import com.example.activemq.consumer.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    Person getByName(String name);
}
