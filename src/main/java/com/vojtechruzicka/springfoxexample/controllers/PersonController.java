package com.vojtechruzicka.springfoxexample.controllers;

import com.vojtechruzicka.springfoxexample.domain.Person;
import com.vojtechruzicka.springfoxexample.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/persons/")
public class PersonController {

    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Person getPersonById(@PathVariable int id) {
        return personService.getPersonById(id);
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
