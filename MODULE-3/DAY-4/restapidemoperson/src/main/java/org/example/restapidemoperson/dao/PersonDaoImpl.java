package org.example.restapidemoperson.dao;

import org.example.restapidemoperson.model.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao{
    private List<Person> personList = new ArrayList<>();
    @Override
    public void addPerson(Person person) {
        personList.add(person);
    }

    @Override
    public Person getPersonById(int id) {
        return personList.stream()
                .filter(person -> person.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updatePerson(int id, Person person) {
        for(int i=0; i< personList.size();i++){
            if(person.getId() == id){
                personList.set(i,person);
                return;

            }
        }
    }

    @Override
    public void deletePerson(int id) {
        personList.removeIf((person) -> person.getId() == id);
    }

    @Override
    public List<Person> getAllPersons() {
        return List.of();
    }
}
