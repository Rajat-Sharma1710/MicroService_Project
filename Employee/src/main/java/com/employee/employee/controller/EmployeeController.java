package com.employee.employee.controller;

import com.employee.employee.model.dto.EmployeeDto;
import com.employee.employee.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService empService) {
        this.employeeService = empService;
    }

    @GetMapping("/{id}")
    private ResponseEntity<EmployeeDto> getEmployee(@PathVariable Long id) {
        EmployeeDto emp = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(emp, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        List<EmployeeDto> empList = employeeService.getAllEmployee();
        return new ResponseEntity<>(empList, HttpStatus.OK);
    }

    @PostMapping("/save")
    private ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto emp) {
        EmployeeDto empResponse = employeeService.createEmployee(emp);
        return new ResponseEntity<>(empResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    private ResponseEntity<EmployeeDto> updateEmployee(@RequestBody EmployeeDto emp, @PathVariable("id") Long id) {
        EmployeeDto empResponse = employeeService.updateEmployee(emp, id);
        return new ResponseEntity<>(empResponse, HttpStatus.OK);
    }

    @DeleteMapping("delete/{empId}")
    private ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable("empId") Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
