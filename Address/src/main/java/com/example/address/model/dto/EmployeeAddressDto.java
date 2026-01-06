package com.example.address.model.dto;

import java.util.List;

public class EmployeeAddressDto {

    private Long empId;

    List<AddressDto> addresses;

    public Long getEmpId() {
        return empId;
    }

    public List<AddressDto> getAddresses() {
        return addresses;
    }
}
