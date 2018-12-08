package com.rent.domainobject;

import com.rent.domainvalue.PaymentType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Table(
        name = "contract",
        uniqueConstraints = @UniqueConstraint(name = "id", columnNames = {"id"})
)
public class ContractDO {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull(message = "Start date can not be null!")
    private ZonedDateTime startDate = ZonedDateTime.now();

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @NotNull(message = "End date can not be null!")
    private ZonedDateTime endDate = ZonedDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentType paymentType;

    @Column(nullable = false)
    @NotNull(message = "Advance number can not be null!")
    private Integer advanceNumber;

    @Column(nullable = false)
    @NotNull(message = "Advance can not be null!")
    private BigDecimal advance;

    @Column(nullable = false)
    @NotNull(message = "Deposit number can not be null!")
    private Integer depositNumber;

    @Column(nullable = false)
    @NotNull(message = "Deposit can not be null!")
    private BigDecimal deposit;

    @Column(nullable = false)
    @NotNull(message = "Amount can not be null!")
    private BigDecimal amount;

    @Column(nullable = false)
    private Boolean deleted = false;

    @OneToOne
    @JoinColumn(name = "person_id")
    @NotNull(message = "Person can not be null!")
    private PersonDO person;

    @OneToOne
    @JoinColumn(name = "property_id")
    @NotNull(message = "Property can not be null!")
    private PropertyDO property;

    public ContractDO() {
    }


    public ContractDO(ZonedDateTime startDate, ZonedDateTime endDate, PaymentType paymentType, Integer advanceNumber,
                      BigDecimal advance, Integer depositNumber, BigDecimal deposit, BigDecimal amount, PersonDO person,
                      PropertyDO property) {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
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

    public PersonDO getPerson() {
        return person;
    }

    public void setPerson(PersonDO person) {
        this.person = person;
    }

    public PropertyDO getProperty() {
        return property;
    }

    public void setProperty(PropertyDO property) {
        this.property = property;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
