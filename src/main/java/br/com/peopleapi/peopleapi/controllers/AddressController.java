package br.com.peopleapi.peopleapi.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.peopleapi.peopleapi.dtos.AddressRequestDTO;
import br.com.peopleapi.peopleapi.dtos.AddressResponseDTO;
import br.com.peopleapi.peopleapi.services.AddressService;

@RestController
@RequestMapping(value = "/api/v1/address")
public class AddressController {

    @Autowired
    private AddressService service;

    @PostMapping
    public ResponseEntity<AddressResponseDTO> insert(@RequestBody AddressRequestDTO dto, @RequestParam Long peopleId) {
        AddressResponseDTO addressDto = service.insert(dto, peopleId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addressDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(addressDto);
    }

    @PostMapping(value = "/main")
    public ResponseEntity<AddressResponseDTO> setAddressMain(@RequestParam Long addressId) {
        AddressResponseDTO addressDto = service.setAddressMain(addressId);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(addressDto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(addressDto);
    }
}
