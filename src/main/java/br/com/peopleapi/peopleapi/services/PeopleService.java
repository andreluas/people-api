package br.com.peopleapi.peopleapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.peopleapi.peopleapi.dtos.PeopleAddressesDTO;
import br.com.peopleapi.peopleapi.dtos.PeopleDTO;
import br.com.peopleapi.peopleapi.entities.People;
import br.com.peopleapi.peopleapi.mappers.PeopleMapper;
import br.com.peopleapi.peopleapi.repository.PeopleRepository;
import br.com.peopleapi.peopleapi.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class PeopleService {

    @Autowired
    private PeopleRepository repository;

    @Autowired
    private PeopleMapper mapper;

    public List<PeopleDTO> findAll() {
        List<People> list = repository.findAll();
        return mapper.entityListToDtoList(list);
    }

    public Page<People> findAllPaged(Pageable pageable) {
        Page<People> list = repository.findAll(pageable);
        return list;
    }

    public PeopleDTO findById(Long id) {
        Optional<People> obj = repository.findById(id);
        People entity = obj.orElseThrow(() -> new ResourceNotFoundException("People not found"));
        return mapper.entityToDTO(entity);
    }

    public PeopleDTO findByCpf(String cpf) {
        Optional<People> op = repository.findByCpf(cpf);
        People entity = op.orElseThrow(() -> new ResourceNotFoundException("CPF not found: " + cpf));
        return mapper.entityToDTO(entity);
    }

    public PeopleAddressesDTO addressesById(Long id) {
        Optional<People> obj = repository.findById(id);
        People entity = obj.orElseThrow(() -> new ResourceNotFoundException("People not found"));
        return mapper.entityToAddressesDTO(entity);
    }

    public PeopleDTO insert(PeopleDTO dto) {
        People entity = mapper.dtoToEntity(dto);
        repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    public PeopleDTO update(Long id, PeopleDTO dto) {
        try {
            People entity = mapper.dtoToEntity(dto);
            repository.save(entity);
            return mapper.entityToDTO(entity);
        } catch (EntityNotFoundException err) {
            throw new ResourceNotFoundException("Id not found: " + id);
        }
    }
}
