package br.com.peopleapi.peopleapi.factory;

import java.time.LocalDate;

import br.com.peopleapi.peopleapi.dtos.PeopleTestDTO;
import br.com.peopleapi.peopleapi.entities.People;

public class Factory {

    public static People createPeople() {
        LocalDate date = LocalDate.parse("1990-10-10");
        People people = new People(1L, "Test", "Test", "78334557094", date);
        return people;
    }

    public static PeopleTestDTO createPeopleDTO() {
        People people = createPeople();
        return new PeopleTestDTO(people);
    }
}
