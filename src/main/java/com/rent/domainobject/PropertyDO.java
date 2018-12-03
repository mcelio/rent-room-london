package com.rent.domainobject;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Table(
        name = "property",
        uniqueConstraints = @UniqueConstraint(name = "id", columnNames = {"id"})
)
public class PropertyDO {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false)
    @NotNull(message = "Address can not be null!")
    private String address;

    @Column(nullable = false)
    @NotNull(message = "Street1 can not be null!")
    private String street1;

    @Column(nullable = false)
    @NotNull(message = "Street2 can not be null!")
    private String street2;

    @Column(nullable = false)
    @NotNull(message = "Street3 can not be null!")
    private String street3;

    @Column(nullable = false)
    @NotNull(message = "Postcode can not be null!")
    private String postcode;

    @Column(nullable = false)
    private Boolean deleted = false;

    public PropertyDO() {
    }


    public PropertyDO(String address, String street1, String street2, String street3, String postcode) {
        this.address = address;
        this.street1 = street1;
        this.street2 = street2;
        this.street3 = street3;
        this.postcode = postcode;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet3() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
