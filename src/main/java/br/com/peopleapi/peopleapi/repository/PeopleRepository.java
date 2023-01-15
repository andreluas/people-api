package br.com.peopleapi.peopleapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.peopleapi.peopleapi.entities.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

    Optional<People> findByCpf(String cpf);
}
