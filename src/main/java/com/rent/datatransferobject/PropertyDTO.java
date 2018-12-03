package com.rent.datatransferobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropertyDTO {

    @JsonIgnore
    private Long id;

    @NotNull(message = "Address Number can not be null!")
    private String address;

    @NotNull(message = "Street 1 can not be null!")
    private String street1;

    @NotNull(message = "Street 2 can not be null!")
    private String street2;

    @NotNull(message = "Street 3 can not be null!")
    private String street3;

    @NotNull(message = "Postcode can not be null!")
    private String postcode;

    public PropertyDTO(){}

    public PropertyDTO(Long id, String address, String street1, String street2, String street3,
                       String postcode){
        this.id = id;
        this.address = address;
        this.street1 = street1;
        this.street2 = street2;
        this.street3 = street3;
        this.postcode = postcode;
    }

    public static PropertyDTOBuilder newBuilder() {
        return new PropertyDTOBuilder();
    }

    @JsonProperty
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public static class PropertyDTOBuilder {
        private Long id;
        private String address;
        private String street1;
        private String street2;
        private String street3;
        private String postcode;

        public PropertyDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public PropertyDTOBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public PropertyDTOBuilder setStreet1(String street1) {
            this.street1 = street1;
            return this;
        }

        public PropertyDTOBuilder setStreet2(String street2) {
            this.street3 = street3;
            return this;
        }

        public PropertyDTOBuilder setStreet3(String street3) {
            this.street3 = street3;
            return this;
        }

        public PropertyDTOBuilder setPostcode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        public PropertyDTO createPropertyDTO() {
            return new PropertyDTO(id, address, street1, street2, street3, postcode);
        }
    }
}
