package com.rent.controller.mapper;

import com.rent.datatransferobject.ContractDTO;
import com.rent.datatransferobject.ContractDTO.ContractDTOBuilder;
import com.rent.domainobject.ContractDO;
import com.rent.domainobject.PersonDO;
import com.rent.domainobject.PropertyDO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ContractMapper {

    public static ContractDO makeContractDO(ContractDTO contractDTO) {
        PersonDO person = new PersonDO();
        person.setId(contractDTO.getPerson());

        PropertyDO property = new PropertyDO();
        property.setId(contractDTO.getProperty());
        return new ContractDO(contractDTO.getStartDate(), contractDTO.getEndDate(),
                contractDTO.getPaymentType(), contractDTO.getAdvanceNumber(), contractDTO.getAdvance(), contractDTO.getDepositNumber(), contractDTO.getDeposit(), contractDTO.getAmount(), person, property);
    }


    public static ContractDTO makeContractDTO(ContractDO contractDO) {
        ContractDTOBuilder contractDTOBuilder = ContractDTO.newBuilder()
                .setId(contractDO.getId())
                .setStartDate(contractDO.getStartDate())
                .setEndDate(contractDO.getEndDate())
                .setAdvanceNumber(contractDO.getAdvanceNumber())
                .setAdvance(contractDO.getAdvance())
                .setDepositNumber(contractDO.getDepositNumber())
                .setDeposit(contractDO.getDeposit())
                .setAmount(contractDO.getAmount())
                .setPerson(contractDO.getPerson().getId())
                .setProperty(contractDO.getProperty().getId());

        return contractDTOBuilder.createContractDTO();
    }


    public static List<ContractDTO> makeContractDTOList(Collection<ContractDO> contracts) {
        return contracts.stream()
                .map(ContractMapper::makeContractDTO)
                .collect(Collectors.toList());
    }
}
