package com.rent.domainobject;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

@Entity
@Table(
        name = "person",
        uniqueConstraints = @UniqueConstraint(name = "id", columnNames = {"id"})
)
public class PersonDO {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false)
    @NotNull(message = "Name can not be null!")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Passport Number can not be null!")
    private String passportNumber;

    @Column(nullable = false)
    @NotNull(message = "Email can not be null!")
    private String email;

    @Column(nullable = false)
    @NotNull(message = "Telephone can not be null!")
    private String telephone;

    @Column(nullable = false)
    private Boolean deleted = false;

    public PersonDO(){}


    public PersonDO(String name, String email, String passportNumber, String telephone){
        this.name = name;
        this.passportNumber = passportNumber;
        this.email = email;
        this.telephone = telephone;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
