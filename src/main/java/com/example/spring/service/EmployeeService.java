package com.example.spring.service;

import com.example.spring.dto.EmployeeDTO;
import com.example.spring.model.Employee;
import com.example.spring.repo.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    // constructor injection instead of autowired as the field is immutable
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployee(){
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private EmployeeDTO convertToDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPosition());
    }

}
