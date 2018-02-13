package com.vojtechruzicka.springfoxexample.services;

import com.vojtechruzicka.springfoxexample.domain.Person;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;

@Service
public class PersonService {

    private List<Person> persons;

    @PostConstruct
    void init() {
        this.persons = new ArrayList<>();

        Person john = new Person(1, "John", "Smith", 42);
        persons.add(john);

        Person jane = new Person(2, "Jane", "Jonhnson", 19);
        persons.add(jane);

        Person kate = new Person(3, "Kate", "Jones", 33);
        persons.add(kate);
    }

    public List<Person> getAllPersons() {
        return this.persons;
    }

    public Person getPersonById(int id) {
        return this.persons
                .stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Person createPerson(Person person) {
        OptionalInt maxId = this.persons.stream().mapToInt(Person::getId).max();
        if (maxId.isPresent()) {
            person.setId(maxId.getAsInt()+1);
        }

        return person;
    }

    public void deletePerson(int id) {
        for (Person person : this.persons) {
            if(person.getId() == id) {
                this.persons.remove(person);
                return;
            }
        }
    }
}
