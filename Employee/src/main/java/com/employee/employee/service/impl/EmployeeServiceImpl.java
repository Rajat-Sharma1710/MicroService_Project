package com.employee.employee.service.impl;

import com.employee.employee.globalException.BadRequestException;
import com.employee.employee.globalException.ResourceNotFoundException;
import com.employee.employee.model.dto.EmployeeDto;
import com.employee.employee.model.entity.Employee;
import com.employee.employee.repository.EmployeeRepo;
import com.employee.employee.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;

    private final ModelMapper mapper;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo, ModelMapper mapper) {
        this.employeeRepo = employeeRepo;
        this.mapper = mapper;
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        if(id == null) throw new BadRequestException("Id should not be null");
        Employee emp = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found!"));
        return mapper.map(emp, EmployeeDto.class);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employee) {
        Employee emp = mapper.map(employee, Employee.class);
        employeeRepo.save(emp);
        return mapper.map(emp, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployee(EmployeeDto employee, Long id) {
        if(id == null) {
            throw new BadRequestException("EmployeeId should not be null!");
        }

        Employee existing = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + id));
        /*
           This mapping always creates a new emp entity and enforces
           hibernate to always insert a new employee record, therefore avoid...
         */
//        Employee emp = mapper.map(employee, Employee.class);

        mapper.map(employee, existing);
        Employee updatedEmp = employeeRepo.save(existing);
        return mapper.map(updatedEmp, EmployeeDto.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        if(id == null) {
            throw new BadRequestException("Id should not be null!!");
        }
        employeeRepo.deleteById(id);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employeeList = employeeRepo.findAll();
        return employeeList.stream()
                .map(emp -> mapper.map(emp, EmployeeDto.class))
                .toList();
    }
}
