package org.example.restapidemoperson.dao;

import org.example.restapidemoperson.model.Person;

import java.util.List;

public interface PersonDao {
    void addPerson(Person person);
    Person getPersonById(int id);
    void updatePerson(int id, Person person);
    void deletePerson(int id);
    List<Person> getAllPersons();
}
