package com.vojtechruzicka.springfoxexample.controllers;

import com.vojtechruzicka.springfoxexample.domain.Person;
import com.vojtechruzicka.springfoxexample.services.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v2/persons/")
@Api(description = "Set of endpoints for Creating, Retrieving, Updating and Deleting of Persons.")
public class PersonController {

    private PersonService personService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiOperation("Returns list of all Persons in the system.")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = "application/json")
    @ApiOperation("Returns a specific person by their identifier. 404 if does not exist.")
    public Person getPersonById(@ApiParam("Id of the person to be obtained. Cannot be empty.")
                                    @PathVariable int id) {
        return personService.getPersonById(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    @ApiOperation("Deletes a person from the system. 404 if the person's identifier is not found.")
    public void deletePerson(@ApiParam("Id of the person to be deleted. Cannot be empty.")
                                 @PathVariable int id) {
        personService.deletePerson(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiOperation("Creates a new person.")
    public Person createPerson(@ApiParam("Person information for a new person to be created.")
                                   @RequestBody Person person) {
        return personService.createPerson(person);
    }

    @Autowired
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}
