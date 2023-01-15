package br.com.peopleapi.peopleapi.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.peopleapi.peopleapi.dtos.PeopleAddressesDTO;
import br.com.peopleapi.peopleapi.dtos.PeopleDTO;
import br.com.peopleapi.peopleapi.entities.People;
import br.com.peopleapi.peopleapi.services.PeopleService;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/people")
public class PeopleController {

    @Autowired
    private PeopleService service;

    @GetMapping
    public ResponseEntity<List<PeopleDTO>> findAll() {
        List<PeopleDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<People>> getAll(Pageable pageable) {
        Page<People> page = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PeopleDTO> findById(@PathVariable Long id) {
        PeopleDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "cpf/{cpf}")
    public ResponseEntity<PeopleDTO> findByCpf(@PathVariable String cpf) {
        PeopleDTO dto = service.findByCpf(cpf);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/{id}/addresses")
    public ResponseEntity<PeopleAddressesDTO> addressesById(@PathVariable Long id) {
        PeopleAddressesDTO dto = service.addressesById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<PeopleDTO> insert(@RequestBody @Valid PeopleDTO dto) {
        PeopleDTO peopleDto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(peopleDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(peopleDto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PeopleDTO> update(@PathVariable Long id, @RequestBody @Valid PeopleDTO dto) {
        PeopleDTO peopleDto = service.update(id, dto);
        return ResponseEntity.ok().body(peopleDto);
    }
}
