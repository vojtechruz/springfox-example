package com.vojtechruzicka.springfoxexample.services;

import com.vojtechruzicka.springfoxexample.domain.Person;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private List<Person> persons;

    @PostConstruct
    void init() {
        this.persons = new ArrayList<>();

        Person john = new Person("John", "Smith", 42);
        persons.add(john);
    }

    public List<Person> getAllPersons() {
        return this.persons;
    }

}
