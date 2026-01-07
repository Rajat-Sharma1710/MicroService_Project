package com.example.address.model.dto;

import com.example.address.model.AddressType;

public class AddressDto {

    private Long id;

    private Long pincode;

    private String street;

    private String country;

    private AddressType addressType;

    public Long getId() {
        return id;
    }

    public Long getPincode() {
        return pincode;
    }

    public String getStreet() {
        return street;
    }

    public String getCountry() {
        return country;
    }

    public AddressType getAddressType() {
        return addressType;
    }
}
