package com.example.address.controller;

import com.example.address.model.dto.AddressDto;
import com.example.address.model.dto.EmployeeAddressDto;
import com.example.address.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    private ResponseEntity<AddressDto> getAddressById(@PathVariable Long id) {
        AddressDto addressDto = addressService.getAddressById(id);
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }

    @GetMapping()
    private ResponseEntity<List<AddressDto>> getAllAddresses() {
        List<AddressDto> addressDtoList = addressService.getAllAddresses();
        return new ResponseEntity<>(addressDtoList, HttpStatus.OK);
    }

    @PostMapping("/save")
    private ResponseEntity<List<AddressDto>> saveAddress(@RequestBody EmployeeAddressDto employeeAddressDto) {
        List<AddressDto> addressDto = addressService.saveAllAddresses(employeeAddressDto);
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }

    // partial update
    @PatchMapping("/update")
    private ResponseEntity<List<AddressDto>> updateAddress(@RequestBody EmployeeAddressDto employeeAddressDto) {
        List<AddressDto> addressDto = addressService.updateReqAddresses(employeeAddressDto);
        return new ResponseEntity<>(addressDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    private ResponseEntity<AddressDto> deleteAddressById(@PathVariable Long id) {
        addressService.deleteAddressById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
