package com.rent.controller.mapper;

import com.rent.datatransferobject.PropertyDTO;
import com.rent.datatransferobject.PropertyDTO.PropertyDTOBuilder;
import com.rent.domainobject.PropertyDO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyMapper {

    public static PropertyDO makePropertyDO(PropertyDTO propertyDTO) {
        return new PropertyDO(propertyDTO.getAddress(), propertyDTO.getStreet1(),
                propertyDTO.getStreet2(), propertyDTO.getStreet3(), propertyDTO.getPostcode());
    }


    public static PropertyDTO makePropertyDTO(PropertyDO propertyDO) {
        PropertyDTOBuilder propertyDTOBuilder = PropertyDTO.newBuilder()
                .setId(propertyDO.getId())
                .setAddress(propertyDO.getAddress())
                .setStreet1(propertyDO.getStreet1())
                .setStreet2(propertyDO.getStreet2())
                .setStreet3(propertyDO.getStreet3())
                .setPostcode(propertyDO.getPostcode());

        return propertyDTOBuilder.createPropertyDTO();
    }


    public static List<PropertyDTO> makePropertyDTOList(Collection<PropertyDO> propertys) {
        return propertys.stream()
                .map(PropertyMapper::makePropertyDTO)
                .collect(Collectors.toList());
    }
}
