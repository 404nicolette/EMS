package com.example.spring;

import com.example.spring.model.Employee;
import com.example.spring.repo.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public Application(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    private final EmployeeRepository employeeRepository;


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Employee> employeeList = new ArrayList<>();

        Employee employee1 = new Employee();
        employee1.setFirstName("John");
        employee1.setLastName("Doe");
        employee1.setPosition("Manager");
        employee1.setEmail("johndoe@email.com");

        LocalDate hireDate1 = LocalDate.of(2022, 12, 23);
        employee1.setHireDate(hireDate1);


        Employee employee2 = new Employee();
        employee2.setFirstName("Emily");
        employee2.setLastName("Smith");
        employee2.setPosition("Junior Software Engineer");
        employee2.setEmail("emilysmith@email.com");

        LocalDate hireDate2 = LocalDate.of(2024, 02, 14);
        employee2.setHireDate(hireDate2);

        employeeList.add(employee1);
        employeeList.add(employee2);

        employeeRepository.saveAll(employeeList);

    }
}
