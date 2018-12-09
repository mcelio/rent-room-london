package com.rent.domainobject;

import com.rent.domainvalue.ChargeType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(
        name = "bill",
        uniqueConstraints = @UniqueConstraint(name = "id", columnNames = {"id"})
)
public class BillDO {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Date dateCreated;

    @Column(nullable = false)
    @NotNull(message = "Energy amount can not be null!")
    private BigDecimal energy;

    @Column(nullable = false)
    @NotNull(message = "Water amount can not be null!")
    private BigDecimal water;

    @Column(nullable = false)
    @NotNull(message = "Council Tax amount can not be null!")
    private BigDecimal councilTax;

    @Column(nullable = false)
    @NotNull(message = "TV license amount can not be null!")
    private BigDecimal tv;

    @Column(nullable = false)
    @NotNull(message = "Internet amount can not be null!")
    private BigDecimal internet;

    @Column(nullable = false)
    @NotNull(message = "Cleaner amount can not be null!")
    private BigDecimal cleaner;

    @Column(nullable = false)
    @NotNull(message = "Additional services amount can not be null!")
    private BigDecimal additionalServices;

    @OneToOne
    @JoinColumn(name = "property_id")
    @NotNull(message = "Property can not be null!")
    private PropertyDO property;

    @Column(nullable = false)
    private Boolean deleted = false;

    public BillDO(){}


    public BillDO(Date dateCreated, BigDecimal energy, BigDecimal water, BigDecimal internet, BigDecimal tv,
                  BigDecimal councilTax, BigDecimal cleaner, BigDecimal additionalServices, PropertyDO property){
        this.dateCreated = dateCreated;
        this.energy = energy;
        this.water = water;
        this.internet = internet;
        this.councilTax = councilTax;
        this.property = property;
        this.cleaner = cleaner;
        this.additionalServices = additionalServices;
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

    public BigDecimal getEnergy() {
        return energy;
    }

    public void setEnergy(BigDecimal energy) {
        this.energy = energy;
    }

    public BigDecimal getWater() {
        return water;
    }

    public void setWater(BigDecimal water) {
        this.water = water;
    }

    public BigDecimal getCouncilTax() {
        return councilTax;
    }

    public void setCouncilTax(BigDecimal councilTax) {
        this.councilTax = councilTax;
    }

    public BigDecimal getTv() {
        return tv;
    }

    public void setTv(BigDecimal tv) {
        this.tv = tv;
    }

    public BigDecimal getInternet() {
        return internet;
    }

    public void setInternet(BigDecimal internet) {
        this.internet = internet;
    }

    public BigDecimal getCleaner() {
        return cleaner;
    }

    public void setCleaner(BigDecimal cleaner) {
        this.cleaner = cleaner;
    }

    public BigDecimal getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(BigDecimal additionalServices) {
        this.additionalServices = additionalServices;
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