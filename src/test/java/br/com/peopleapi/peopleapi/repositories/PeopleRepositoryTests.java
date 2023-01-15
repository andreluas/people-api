package br.com.peopleapi.peopleapi.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import br.com.peopleapi.peopleapi.entities.People;
import br.com.peopleapi.peopleapi.factory.Factory;
import br.com.peopleapi.peopleapi.repository.PeopleRepository;

@DataJpaTest
public class PeopleRepositoryTests {

    @Autowired
    private PeopleRepository repository;

    private long existingId;
    private long nonExistingId;
    private Long countTotalPeoples;

    @BeforeEach
    void setUp() throws Exception {
        existingId = 1L;
        nonExistingId = 1000L;
        countTotalPeoples = 5L;
    }

    @Test
    public void findByIdShouldReturnNonEmptyOptionalPeopleWhenIdExists() {

        Optional<People> result = repository.findById(existingId);
        Assertions.assertTrue(result.isPresent());
    }

    @Test
    public void findByIdShouldReturnEmptyOptionalWhenIdDoesNotExist() {

        Optional<People> result = repository.findById(nonExistingId);
        Assertions.assertTrue(result.isEmpty());
    }

    @Test
    public void saveShouldPersistWithAutoIncrementWhenIdIsNull() {

        People people = Factory.createPeople();
        people.setId(null);
        repository.save(people);
        Assertions.assertNotNull(people.getId());
        Assertions.assertEquals(countTotalPeoples + 1, people.getId());
    }

    @Test
    public void deleteShouldDeleteObjectWhenIdExists() {

        repository.deleteById(existingId);
        Optional<People> result = repository.findById(existingId);
        Assertions.assertFalse(result.isPresent());
    }

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {

        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
            repository.deleteById(nonExistingId);
        });
    }
}
