package com.rent.domainobject;

import com.rent.domainvalue.ChargeType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(
        name = "payment",
        uniqueConstraints = @UniqueConstraint(name = "id", columnNames = {"id"})
)
public class PaymentDO {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Date dateCreated;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NotNull(message = "Charge type can not be null!")
    private ChargeType chargeType;

    @Column(nullable = false)
    @NotNull(message = "Description can not be null!")
    private String description;

    @Column(nullable = false)
    @NotNull(message = "Amount can not be null!")
    private BigDecimal amount;

    @OneToOne
    @JoinColumn(name = "contract_id")
    @NotNull(message = "Contract can not be null!")
    private ContractDO contract;

    @Column(nullable = false)
    private Boolean deleted = false;

    public PaymentDO(){}


    public PaymentDO(Date dateCreated, ChargeType chargeType, String description, BigDecimal amount, ContractDO contract){
        this.dateCreated = dateCreated;
        this.chargeType = chargeType;
        this.description = description;
        this.amount = amount;
        this.contract = contract;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
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

    public ContractDO getContract() {
        return contract;
    }

    public void setContract(ContractDO contract) {
        this.contract = contract;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
