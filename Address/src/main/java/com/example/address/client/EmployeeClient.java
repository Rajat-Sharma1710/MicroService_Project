package com.example.address.client;


import com.example.address.model.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Employee", url = "${client.employee.url}")
public interface EmployeeClient {

    @GetMapping("/api/v1/employee/{id}")
    EmployeeDto getEmployeeById(@PathVariable Long id);
}
