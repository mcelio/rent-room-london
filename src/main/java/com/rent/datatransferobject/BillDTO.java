package com.rent.datatransferobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillDTO {

    @JsonIgnore
    private Long id;

    @NotNull(message = "Date can not be null!")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date date;

    @NotNull(message = "Energy amount can not be null!")
    private BigDecimal energy;

    @NotNull(message = "Water amount can not be null!")
    private BigDecimal water;

    @NotNull(message = "Council tax amount can not be null!")
    private BigDecimal councilTax;

    @NotNull(message = "Internet amount can not be null!")
    private BigDecimal internet;

    @NotNull(message = "Addicitonal services amount can not be null!")
    private BigDecimal additionalServices;

    @NotNull(message = "TV amount can not be null!")
    private BigDecimal tv;

    @NotNull(message = "Cleaner amount can not be null!")
    private BigDecimal cleaner;

    @NotNull(message = "Property can not be null!")
    private Long property;

    public BillDTO(){}

    public BillDTO(Long id, Date date, BigDecimal energy, BigDecimal water, BigDecimal tv, BigDecimal internet,
                   BigDecimal cleaner, BigDecimal councilTax, BigDecimal additionalServices, Long property){
        this.id = id;
        this.date = date;
        this.energy = energy;
        this.water = water;
        this.tv = tv;
        this.internet = internet;
        this.cleaner = cleaner;
        this.councilTax = councilTax;
        this.additionalServices = additionalServices;
        this.property = property;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public BigDecimal getInternet() {
        return internet;
    }

    public void setInternet(BigDecimal internet) {
        this.internet = internet;
    }

    public BigDecimal getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(BigDecimal additionalServices) {
        this.additionalServices = additionalServices;
    }

    public BigDecimal getTv() {
        return tv;
    }

    public void setTv(BigDecimal tv) {
        this.tv = tv;
    }

    public BigDecimal getCleaner() {
        return cleaner;
    }

    public void setCleaner(BigDecimal cleaner) {
        this.cleaner = cleaner;
    }

    public Long getProperty() {
        return property;
    }

    public void setProperty(Long property) {
        this.property = property;
    }

    public static BillDTOBuilder newBuilder() {
        return new BillDTOBuilder();
    }

    @JsonProperty
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public static class BillDTOBuilder {

        private Long id;
        private Date date;
        private BigDecimal energy;
        private BigDecimal water;
        private BigDecimal councilTax;
        private BigDecimal tv;
        private BigDecimal internet;
        private BigDecimal cleaner;
        private BigDecimal additionalServices;
        private Long property;

        public BillDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public BillDTOBuilder setDate(Date date) {
            this.date = date;
            return this;
        }

        public BillDTOBuilder setWater(BigDecimal water) {
            this.water = water;
            return this;
        }

        public BillDTOBuilder setInternet(BigDecimal internet) {
            this.internet = internet;
            return this;
        }

        public BillDTOBuilder setTV(BigDecimal tv) {
            this.tv = tv;
            return this;
        }

        public BillDTOBuilder setEnergy(BigDecimal energy) {
            this.energy = energy;
            return this;
        }

        public BillDTOBuilder setCouncilTax(BigDecimal councilTax) {
            this.councilTax = councilTax;
            return this;
        }

        public BillDTOBuilder setCleaner(BigDecimal cleaner) {
            this.cleaner = cleaner;
            return this;
        }

        public BillDTOBuilder setAdditionalServices(BigDecimal additionalServices) {
            this.additionalServices = additionalServices;
            return this;
        }

        public BillDTOBuilder setProperty(Long property) {
            this.property = property;
            return this;
        }

        public BillDTO createBillDTO() {
            return new BillDTO(id, date, energy, water, tv, internet, cleaner, councilTax, additionalServices,
                    property);
        }
    }
}
