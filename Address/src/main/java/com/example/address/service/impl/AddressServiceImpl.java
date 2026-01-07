package com.example.address.service.impl;

import com.example.address.globalException.BadRequestException;
import com.example.address.globalException.ResourceNotFoundException;
import com.example.address.model.dto.AddressDto;
import com.example.address.model.dto.EmployeeAddressDto;
import com.example.address.model.entity.Address;
import com.example.address.repository.AddressRepo;
import com.example.address.service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepo addressRepo;

    private final ModelMapper mapper;

    public AddressServiceImpl(AddressRepo addressRepo, ModelMapper mapper) {
        this.addressRepo = addressRepo;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public AddressDto getAddressById(Long id) {
        if(id == null) throw new BadRequestException("Id should not be null");
        Address address = addressRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found"));
        return mapper.map(address, AddressDto.class);
    }

    @Override
    @Transactional
    public List<AddressDto> getAllAddresses() {
        List<Address> address = addressRepo.findAll();
        return address.stream()
                .map(add -> mapper.map(add, AddressDto.class)).toList();
    }

    @Override
    @Transactional
    public List<AddressDto> saveAllAddresses(EmployeeAddressDto employeeAddressDto) {
        Long empId = employeeAddressDto.getEmpId();
        if(empId == null) {
            throw new BadRequestException("Employee ID should not be null!!");
        }
        // TODO: We need to check whether emp with this ID is present or not

        List<AddressDto> addressDtoList = employeeAddressDto.getAddresses();
        List<Address> addresses = addressDtoList.stream()
                .map(addDTO -> {
                    Address add = mapper.map(addDTO, Address.class);
                    add.setEmpId(empId);
                    return add;
                }).toList();

        List<Address> savedAddresses = addressRepo.saveAll(addresses);
        return savedAddresses.stream()
                .map(add -> mapper.map(add, AddressDto.class)).toList();
    }

    @Override
    @Transactional
    public List<AddressDto> updateReqAddresses(EmployeeAddressDto employeeAddressDto) {
        if(employeeAddressDto.getEmpId() == null) {
            throw new BadRequestException("Employee ID should not be null!!");
        }
        // TODO: We need to check whether emp with this ID is present or not

        /*
            In this list few of the addressDTOs have the ID while the others
            have null, so we need to save the null ones while update the fresh ones
        */
        List<AddressDto> addressDtoList = employeeAddressDto.getAddresses();

        Map<Boolean, List<AddressDto>> addressToUpdateAndSave = addressDtoList.stream()
                .collect(Collectors.partitioningBy(addDto -> addDto.getId() != null));
        List<Address> addressToUpdate = addressToUpdateAndSave.get(true)
                .stream().map(addDto -> {
                    Address add = mapper.map(addDto, Address.class);
                    add.setEmpId(employeeAddressDto.getEmpId());
                    return add;
                }).toList();

        List<Address> addressToSave = addressToUpdateAndSave.get(false)
                .stream().map(addDto -> {
                    Address ad = mapper.map(addDto, Address.class);
                    ad.setEmpId(employeeAddressDto.getEmpId());
                    return ad;
                }).toList();

        List<Address> updatedAddress_1 = addressRepo.saveAll(addressToSave);
        List<Address> updatedAddress_2 = addressRepo.saveAll(addressToUpdate);

        List<Address> completeUpdated = new ArrayList<>();
        completeUpdated.addAll(updatedAddress_1);
        completeUpdated.addAll(updatedAddress_2);

        return completeUpdated.stream().map(add -> mapper.map(add, AddressDto.class)).toList();
    }

    @Override
    @Transactional
    public void deleteAddressById(Long id) {
        if(id == null) throw new BadRequestException("Id should not be null");
        addressRepo.deleteById(id);
    }
}
