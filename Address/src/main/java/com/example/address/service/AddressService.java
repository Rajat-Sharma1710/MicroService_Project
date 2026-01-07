package com.example.address.service;

import com.example.address.model.dto.AddressDto;
import com.example.address.model.dto.EmployeeAddressDto;

import java.util.List;

public interface AddressService {

    AddressDto getAddressById(Long id);

    List<AddressDto> getAllAddresses();

    List<AddressDto> saveAllAddresses(EmployeeAddressDto employeeAddressDto);

    List<AddressDto> updateReqAddresses(EmployeeAddressDto employeeAddressDto);

    void deleteAddressById(Long id);
}
