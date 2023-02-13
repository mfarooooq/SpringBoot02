package com.skyridge.service;

import com.skyridge.dto.EmployeeDepartmentDto;
import com.skyridge.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDepartmentDto getEmployee(Long id);
}
