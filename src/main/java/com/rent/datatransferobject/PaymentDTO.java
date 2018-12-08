package com.rent.datatransferobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rent.domainvalue.ChargeType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentDTO {

    @JsonIgnore
    private Long id;

    @NotNull(message = "Date can not be null!")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime date = ZonedDateTime.now();

    @NotNull(message = "Charge type can not be null!")
    private ChargeType chargeType;

    @NotNull(message = "Description can not be null!")
    private String description;

    @NotNull(message = "Amount can not be null!")
    private BigDecimal amount;

    @NotNull(message = "Contract can not be null!")
    private Long contract;

    public PaymentDTO(){}

    public PaymentDTO(Long id, ZonedDateTime date, ChargeType chargeType, String description, BigDecimal amount, Long contract){
        this.id = id;
        this.date = date;
        this.chargeType = chargeType;
        this.description = description;
        this.amount = amount;
        this.contract = contract;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public ChargeType getChargeType() {
        return chargeType;
    }

    public void setChargeType(ChargeType chargeType) {
        this.chargeType = chargeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getContract() {
        return contract;
    }

    public void setContract(Long contract) {
        this.contract = contract;
    }

    public static PaymentDTOBuilder newBuilder() {
        return new PaymentDTOBuilder();
    }

    @JsonProperty
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public static class PaymentDTOBuilder {

        private Long id;
        private ZonedDateTime date;
        private ChargeType chargeType;
        private String description;
        private BigDecimal amount;
        private Long contract;

        public PaymentDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public PaymentDTOBuilder setDate(ZonedDateTime date) {
            this.date = date;
            return this;
        }

        public PaymentDTOBuilder setChargeType(ChargeType chargeType) {
            this.chargeType = chargeType;
            return this;
        }

        public PaymentDTOBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public PaymentDTOBuilder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public PaymentDTOBuilder setContract(Long contract) {
            this.contract = contract;
            return this;
        }

        public PaymentDTO createPaymentDTO() {
            return new PaymentDTO(id, date, chargeType, description, amount, contract);
        }
    }
}
