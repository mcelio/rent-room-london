package com.rent.datatransferobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonDTO {

    @JsonIgnore
    private Long id;

    @NotNull(message = "Name can not be null!")
    private String name;

    @NotNull(message = "Passport Number can not be null!")
    private String passportNumber;

    @NotNull(message = "Email can not be null!")
    private String email;

    @NotNull(message = "Telephone can not be null!")
    private String telephone;

    public PersonDTO(){}

    public PersonDTO(Long id, String name, String email, String passportNumber, String telephone){
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
        this.email = email;
        this.telephone = telephone;
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

    public static class PersonDTOBuilder {

        private Long id;
        private String name;
        private String passportNumber;
        private String email;
        private String telephone;

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

        public PersonDTO createPersonDTO() {
            return new PersonDTO(id, name, passportNumber, email, telephone);
        }
    }
}
