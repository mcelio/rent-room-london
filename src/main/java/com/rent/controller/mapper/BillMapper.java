package com.rent.controller.mapper;

import com.rent.datatransferobject.BillDTO;
import com.rent.datatransferobject.BillDTO.BillDTOBuilder;
import com.rent.domainobject.BillDO;
import com.rent.domainobject.PropertyDO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class BillMapper {

    public static BillDO makeBillDO(BillDTO billDTO) {
        PropertyDO property = new PropertyDO();
        property.setId(billDTO.getProperty());
        return new BillDO(billDTO.getDate(), billDTO.getEnergy(),
                billDTO.getWater(), billDTO.getInternet(), billDTO.getTv(), billDTO.getCouncilTax(),
                billDTO.getCleaner(), billDTO.getAdditionalServices(), property);
    }


    public static BillDTO makeBillDTO(BillDO billDO) {
        BillDTOBuilder billDTOBuilder = BillDTO.newBuilder()
                .setId(billDO.getId())
                .setDate(billDO.getDateCreated())
                .setEnergy(billDO.getEnergy())
                .setWater(billDO.getWater())
                .setInternet(billDO.getInternet())
                .setTV(billDO.getTv())
                .setCleaner(billDO.getCleaner())
                .setCouncilTax(billDO.getCouncilTax())
                .setAdditionalServices(billDO.getAdditionalServices())
                .setProperty(billDO.getProperty().getId());

        return billDTOBuilder.createBillDTO();
    }


    public static List<BillDTO> makeBillDTOList(Collection<BillDO> bills) {
        return bills.stream()
                .map(BillMapper::makeBillDTO)
                .collect(Collectors.toList());
    }
}
