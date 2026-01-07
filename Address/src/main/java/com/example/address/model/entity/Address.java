package com.example.address.model.entity;

import com.example.address.model.AddressType;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pincode;

    private Long empId;

    private String street;

    private String country;

    @Enumerated(EnumType.STRING)
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

    public void setEmpId(Long empId) {
        this.empId = empId;
    }
}
