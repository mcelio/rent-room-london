package com.rent.datatransferobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rent.domainvalue.PaymentType;

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

    @NotNull(message = "Contract can not be null!")
    private Long person;

    @NotNull(message = "Property can not be null!")
    private Long property;

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

    public static ContractDTOBuilder newBuilder() {
        return new ContractDTOBuilder();
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

    public Long getContract() {
        return person;
    }

    public void setContract(Long person) {
        this.person = person;
    }

    public Long getProperty() {
        return property;
    }

    public void setProperty(Long property) {
        this.property = property;
    }

    public Long getPerson() {
        return person;
    }

    public void setPerson(Long person) {
        this.person = person;
    }

    public static class ContractDTOBuilder {

        private Long id;
        private ZonedDateTime startDate;
        private ZonedDateTime endDate;
        private PaymentType paymentType;
        private Integer advanceNumber;
        private BigDecimal advance;
        private Integer depositNumber;
        private BigDecimal deposit;
        private BigDecimal amount;
        private Long person;
        private Long property;

        public ContractDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ContractDTOBuilder setStartDate(ZonedDateTime startDate) {
            this.startDate = startDate;
            return this;
        }

        public ContractDTOBuilder setEndDate(ZonedDateTime endDate) {
            this.endDate = endDate;
            return this;
        }

        public ContractDTOBuilder setPaymentType(PaymentType paymentType) {
            this.paymentType = paymentType;
            return this;
        }

        public ContractDTOBuilder setAdvanceNumber(Integer advanceNumber) {
            this.advanceNumber = advanceNumber;
            return this;
        }

        public ContractDTOBuilder setDepositNumber(Integer depositNumber) {
            this.depositNumber = depositNumber;
            return this;
        }

        public ContractDTOBuilder setAdvance(BigDecimal advance) {
            this.advance = advance;
            return this;
        }

        public ContractDTOBuilder setDeposit(BigDecimal deposit) {
            this.deposit = deposit;
            return this;
        }

        public ContractDTOBuilder setAmount(BigDecimal amount) {
            this.amount = amount;
            return this;
        }

        public ContractDTOBuilder setPerson(Long person) {
            this.person = person;
            return this;
        }

        public ContractDTOBuilder setProperty(Long property) {
            this.property = property;
            return this;
        }

        public ContractDTO createContractDTO() {
            return new ContractDTO(id, startDate, endDate, paymentType, advanceNumber,
                    advance, depositNumber, deposit, amount, person,
                    property);
        }
    }
}
