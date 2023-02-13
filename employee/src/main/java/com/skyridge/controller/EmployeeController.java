package com.skyridge.controller;

import com.skyridge.dto.EmployeeDepartmentDto;
import com.skyridge.dto.EmployeeDto;
import com.skyridge.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("{id}")
    public ResponseEntity<EmployeeDepartmentDto> getEmployee(@PathVariable("id") Long id){
        EmployeeDepartmentDto employeeDepartmentDto = employeeService.getEmployee(id);
        return new ResponseEntity<>(employeeDepartmentDto, HttpStatus.OK);

    }
}
