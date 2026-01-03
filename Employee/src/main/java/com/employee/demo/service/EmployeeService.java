package com.employee.demo.service;

import com.employee.demo.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto getEmployeeById(Long id);
    EmployeeDto createEmployee(EmployeeDto employee);
    EmployeeDto updateEmployee(EmployeeDto employee, Long id);
    void deleteEmployee(Long id);
    List<EmployeeDto> getAllEmployee();
}
