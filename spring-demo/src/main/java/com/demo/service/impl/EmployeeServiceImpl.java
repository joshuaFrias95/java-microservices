package com.demo.service.impl;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employeeList = new ArrayList<>();

    @Override
    public Employee save(Employee employee) {

        if (employee.getEmployeeID() == null || employee.getEmailId().isEmpty()) {
            employee.setEmployeeID(UUID.randomUUID().toString());
        }

        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeList
                .stream()
                .filter(employee -> employee.getEmployeeID().equals(id))
                .findFirst()
                .get();
    }
}