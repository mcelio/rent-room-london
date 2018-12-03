package com.rent.controller.mapper;

import com.rent.datatransferobject.PersonDTO;
import com.rent.datatransferobject.PersonDTO.PersonDTOBuilder;
import com.rent.domainobject.PersonDO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PersonMapper {

    public static PersonDO makePersonDO(PersonDTO personDTO) {
        return new PersonDO(personDTO.getName(), personDTO.getPassportNumber(),
                personDTO.getEmail(), personDTO.getTelephone());
    }


    public static PersonDTO makePersonDTO(PersonDO personDO) {
        PersonDTOBuilder personDTOBuilder = PersonDTO.newBuilder()
                .setId(personDO.getId())
                .setName(personDO.getName())
                .setPassportNumber(personDO.getPassportNumber())
                .setEmail(personDO.getEmail())
                .setTelephone(personDO.getTelephone());

        return personDTOBuilder.createPersonDTO();
    }


    public static List<PersonDTO> makePersonDTOList(Collection<PersonDO> persons) {
        return persons.stream()
                .map(PersonMapper::makePersonDTO)
                .collect(Collectors.toList());
    }
}
