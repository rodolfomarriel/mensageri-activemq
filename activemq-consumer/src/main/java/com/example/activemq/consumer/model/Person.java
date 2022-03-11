package com.example.activemq.consumer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {
    @GeneratedValue
    @Id
    private int id;
    @Column(
            name = "name"
    )
    private String name;
    @Column(
            name = "age"
    )
    private int age;

    public String toString() {
        return "Person{id=" + this.id + ", name='" + this.name + "', age=" + this.age + "}";
    }

    public static Person.PersonBuilder builder() {
        return new Person.PersonBuilder();
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public Person(final int id, final String name, final int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public static class PersonBuilder {
        private int id;
        private String name;
        private int age;

        PersonBuilder() {
        }

        public Person.PersonBuilder id(final int id) {
            this.id = id;
            return this;
        }

        public Person.PersonBuilder name(final String name) {
            this.name = name;
            return this;
        }

        public Person.PersonBuilder age(final int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this.id, this.name, this.age);
        }

        public String toString() {
            return "Person.PersonBuilder(id=" + this.id + ", name=" + this.name + ", age=" + this.age + ")";
        }
    }
}
