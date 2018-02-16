package com.vojtechruzicka.springfoxexample.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;

@ApiModel(description = "Class representing a person tracked by the application.")
public class Person {
    @NotNull
    @ApiModelProperty(notes = "${person.id}", example = "1", required = true, position = 0)
    private int id;

    @NotBlank
    @Size(min = 1, max = 20)
    @ApiModelProperty(notes = "${person.firstname}", example = "John", required = true, position = 1)
    private String firstName;

    @NotBlank
    @Pattern(regexp ="[SOME REGULAR EXPRESSION]")
    @ApiModelProperty(notes = "${person.lastlame}", example = "Doe", required = true, position = 2)
    private String lastName;

    @Min(0)
    @Max(100)
    @ApiModelProperty(notes = "${person.age}", example = "42", position = 3)
    private int age;

    public Person() {
    }

    public Person(int id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
