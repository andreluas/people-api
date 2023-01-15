package br.com.peopleapi.peopleapi.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.peopleapi.peopleapi.dtos.AddressDTO;
import br.com.peopleapi.peopleapi.dtos.AddressRequestDTO;
import br.com.peopleapi.peopleapi.dtos.AddressResponseDTO;
import br.com.peopleapi.peopleapi.entities.Address;

@Mapper(componentModel = "spring", unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE)
public interface AddressMapper {

    Address dtoToEntity(AddressDTO addressDTO);

    Address addressReqDtoToEntity(AddressRequestDTO addressReq);

    AddressDTO entityToDTO(Address address);

    AddressResponseDTO entityToAddressResDTO(Address address);

    List<AddressDTO> entityListToDTOList(List<Address> addressList);
}
