package com.example.spring.controller;

import com.example.spring.dto.EmployeeDTO;
import com.example.spring.repo.EmployeeRepository;
import com.example.spring.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/get-all-employees")
    public String getAllEmployees(Model model) {
        List<EmployeeDTO> employeeList = employeeService.getAllEmployee();
        model.addAttribute("employees", employeeList);
        // note to self the parameter of model attribute-> 1st param is in the jsp, 2nd param is in the service layer
        return "allEmployees";
    }
}
