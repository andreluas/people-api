package br.com.peopleapi.peopleapi.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.peopleapi.peopleapi.dtos.AddressRequestDTO;
import br.com.peopleapi.peopleapi.dtos.AddressResponseDTO;
import br.com.peopleapi.peopleapi.entities.Address;
import br.com.peopleapi.peopleapi.entities.People;
import br.com.peopleapi.peopleapi.mappers.AddressMapper;
import br.com.peopleapi.peopleapi.repository.AddressRepository;
import br.com.peopleapi.peopleapi.repository.PeopleRepository;
import br.com.peopleapi.peopleapi.services.exceptions.ResourceNotFoundException;

@Service
@Transactional
public class AddressService {

    @Autowired
    private AddressRepository repository;

    @Autowired
    private PeopleRepository peopleRepository;

    @Autowired
    private AddressMapper mapper;

    public AddressResponseDTO insert(AddressRequestDTO dto, Long peopleId) {
        Optional<People> peopleOp = peopleRepository.findById(peopleId);
        People peopleEntity = peopleOp
                .orElseThrow(() -> new ResourceNotFoundException("People not found with id: " + peopleId));
        Address entity = mapper.addressReqDtoToEntity(dto);
        entity.setPeople(peopleEntity);
        entity.setMain(false);
        repository.save(entity);
        return mapper.entityToAddressResDTO(entity);
    }

    public AddressResponseDTO setAddressMain(Long addressId) {
        Optional<Address> op = repository.findById(addressId);
        Address entity = op.orElseThrow(() -> new ResourceNotFoundException("Address not found: " + addressId));
        Set<Address> peopleAddresses = entity.getPeople().getAddresses();
        for (Address address : peopleAddresses) {
            address.setMain(false);
        }
        entity.setMain(true);
        repository.save(entity);
        return mapper.entityToAddressResDTO(entity);
    }
}
