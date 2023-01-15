package br.com.peopleapi.peopleapi.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.peopleapi.peopleapi.dtos.PeopleAddressesDTO;
import br.com.peopleapi.peopleapi.dtos.PeopleDTO;
import br.com.peopleapi.peopleapi.entities.People;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface PeopleMapper {

    People dtoToEntity(PeopleDTO peopleDTO);

    PeopleDTO entityToDTO(People people);

    PeopleAddressesDTO entityToAddressesDTO(People people);

    List<PeopleDTO> entityListToDtoList(List<People> peopleList);
}
