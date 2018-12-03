package com.rent.datatransferobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rent.domainobject.PersonDO;
import com.rent.domainobject.PropertyDO;
import com.rent.domainvalue.PaymentType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContractDTO {

    @JsonIgnore
    private Long id;

    @NotNull(message = "Start date can not be null!")
    private ZonedDateTime startDate = ZonedDateTime.now();

    @NotNull(message = "End date can not be null!")
    private ZonedDateTime endDate = ZonedDateTime.now();

    @NotNull(message = "Payment type can not be null!")
    private PaymentType paymentType;

    @NotNull(message = "Advance number can not be null!")
    private Integer advanceNumber;

    @NotNull(message = "Advance can not be null!")
    private BigDecimal advance;

    @NotNull(message = "Deposit number can not be null!")
    private Integer depositNumber;

    @NotNull(message = "Deposit can not be null!")
    private BigDecimal deposit;

    @NotNull(message = "Amount can not be null!")
    private BigDecimal amount;

    private Boolean deleted = false;

    @NotNull(message = "Person can not be null!")
    private Long personId;

    @NotNull(message = "Property can not be null!")
    private Long propertyId;

    public ContractDTO() {
    }

    public ContractDTO(Long id, ZonedDateTime startDate, ZonedDateTime endDate, PaymentType paymentType, Integer advanceNumber,
                       BigDecimal advance, Integer depositNumber, BigDecimal deposit, BigDecimal amount, Long person,
                       Long property) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paymentType = paymentType;
        this.advanceNumber = advanceNumber;
        this.advance = advance;
        this.depositNumber = depositNumber;
        this.deposit = deposit;
        this.amount = amount;
        this.person = person;
        this.property = property;
    }

    public static PersonDTOBuilder newBuilder() {
        return new PersonDTOBuilder();
    }

    @JsonProperty
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate;
    }

    public ZonedDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getAdvanceNumber() {
        return advanceNumber;
    }

    public void setAdvanceNumber(Integer advanceNumber) {
        this.advanceNumber = advanceNumber;
    }

    public BigDecimal getAdvance() {
        return advance;
    }

    public void setAdvance(BigDecimal advance) {
        this.advance = advance;
    }

    public Integer getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(Integer depositNumber) {
        this.depositNumber = depositNumber;
    }

    public BigDecimal getDeposit() {
        return deposit;
    }

    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Long getPerson() {
        return personId;
    }

    public void setPerson(Long personId) {
        this.personId = personId;
    }

    public Long getProperty() {
        return propertyId;
    }

    public void setProperty(Long propertyId) {
        this.propertyId = propertyId;
    }

    public static class PersonDTOBuilder {

        private Long id;
        private ZonedDateTime startDate;
        private ZonedDateTime endDate;
        private PaymentType paymentType;
        private Integer advanceNumber;
        private BigDecimal advance;
        private BigDecimal depositNumber;
        private Integer deposit;
        private BigDecimal amount;
        private  Long personId;
        private  Long propertyId;

        public PersonDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public PersonDTOBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonDTOBuilder setPassportNumber(String passportNumber) {
            this.passportNumber = passportNumber;
            return this;
        }

        public PersonDTOBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public PersonDTOBuilder setTelephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public ContractDTO createContractDTO() {
            return new ContractDTO(id, name, passportNumber, email, telephone);
        }
    }
}
