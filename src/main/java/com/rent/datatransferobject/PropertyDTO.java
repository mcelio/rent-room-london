package com.rent.datatransferobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropertyDTO {

    @JsonIgnore
    private Long id;

    @NotNull(message = "Address 1 can not be null!")
    private String address1;

    @NotNull(message = "Address 2 can not be null!")
    private String address2;

    @NotNull(message = "Address 3 can not be null!")
    private String address3;

    @NotNull(message = "Postcode can not be null!")
    private String postcode;

    public PropertyDTO(){}

    public PropertyDTO(Long id, String address1, String address2, String address3,
                       String postcode){
        this.id = id;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
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

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }
    public String getAddress3() {
        return address3;
    }

    public void setAddress(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public static class PropertyDTOBuilder {
        private Long id;
        private String address1;
        private String address2;
        private String address3;
        private String postcode;

        public PropertyDTOBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public PropertyDTOBuilder setAddress1(String address1) {
            this.address1 = address1;
            return this;
        }

        public PropertyDTOBuilder setAddress2(String address2) {
            this.address2 = address2;
            return this;
        }

        public PropertyDTOBuilder setAddress3(String address3) {
            this.address3 = address3;
            return this;
        }

        public PropertyDTOBuilder setPostcode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        public PropertyDTO createPropertyDTO() {
            return new PropertyDTO(id, address1, address2, address3, postcode);
        }
    }
}
