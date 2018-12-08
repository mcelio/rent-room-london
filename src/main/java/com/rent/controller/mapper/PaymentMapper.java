package com.rent.controller.mapper;

import com.rent.datatransferobject.PaymentDTO;
import com.rent.datatransferobject.PaymentDTO.PaymentDTOBuilder;
import com.rent.domainobject.ContractDO;
import com.rent.domainobject.PaymentDO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class PaymentMapper {

    public static PaymentDO makePaymentDO(PaymentDTO paymentDTO) {
        ContractDO contract = new ContractDO();
        contract.setId(paymentDTO.getContract());
        return new PaymentDO(paymentDTO.getDate(), paymentDTO.getChargeType(),
                paymentDTO.getDescription(), paymentDTO.getAmount(), contract);
    }


    public static PaymentDTO makePaymentDTO(PaymentDO paymentDO) {
        PaymentDTOBuilder paymentDTOBuilder = PaymentDTO.newBuilder()
                .setId(paymentDO.getId())
                .setDate(paymentDO.getDateCreated())
                .setChargeType(paymentDO.getChargeType())
                .setDescription(paymentDO.getDescription())
                .setAmount(paymentDO.getAmount())
                .setContract(paymentDO.getContract().getId());

        return paymentDTOBuilder.createPaymentDTO();
    }


    public static List<PaymentDTO> makePaymentDTOList(Collection<PaymentDO> payments) {
        return payments.stream()
                .map(PaymentMapper::makePaymentDTO)
                .collect(Collectors.toList());
    }
}
