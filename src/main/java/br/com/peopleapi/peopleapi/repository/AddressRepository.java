package br.com.peopleapi.peopleapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.peopleapi.peopleapi.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
