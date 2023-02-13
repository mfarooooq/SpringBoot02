package com.skyridge.service.Impl;

import com.skyridge.dto.DepartmentDto;
import com.skyridge.dto.EmployeeDepartmentDto;
import com.skyridge.dto.EmployeeDto;
import com.skyridge.entity.Employee;
import com.skyridge.repository.EmployeeRepository;
import com.skyridge.service.APIClient;
import com.skyridge.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

//     private RestTemplate restTemplate;
//    private WebClient webClient;
    private APIClient apiClient;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee(employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode(),
                employeeDto.getOrganizationCode());

        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = new EmployeeDto(savedEmployee.getId(),
                savedEmployee.getFirstName(), savedEmployee.getLastName(),
                savedEmployee.getEmail(), savedEmployee.getDepartmentCode(), savedEmployee.getOrganizationCode());

        return savedEmployeeDto;
    }

    @Override
    public EmployeeDepartmentDto getEmployee(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        String empDepartment = employee.getDepartmentCode();
// using rest template
//        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/"+empDepartment, DepartmentDto.class);
//        DepartmentDto departmentDto = responseEntity.getBody();

// using web client
//        DepartmentDto  departmentDto = webClient.get().uri("http://localhost:8080/api/departments/"+empDepartment)
//                .retrieve().bodyToMono(DepartmentDto.class).block();

// using feign client
        DepartmentDto  departmentDto = apiClient.getDepartment(empDepartment);
        EmployeeDto employeeDto = new EmployeeDto(employee.getId(),
                employee.getFirstName(), employee.getLastName(),
                employee.getEmail(), employee.getDepartmentCode(), employee.getOrganizationCode());
        EmployeeDepartmentDto employeeDepartmentDto = new EmployeeDepartmentDto(employeeDto, departmentDto);
        return employeeDepartmentDto;
    }
}
