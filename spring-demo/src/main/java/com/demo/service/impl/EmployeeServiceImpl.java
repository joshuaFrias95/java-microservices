package com.demo.service.impl;

import com.demo.exceptions.EmployeeNotFoundException;
import com.demo.model.Employee;
import com.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("EmployeeServiceImpl")
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
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id " + id));
    }

    @Override
    public String deleteEmployeeByid(String id) {
        Employee employee = employeeList.stream()
                .filter(e -> e.getEmployeeID().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(("Can't remove employee with id \'" + id + "\'. Employee not found")));

        employeeList.remove(employee);

        return "The employee with the id \'" + id + "\' was removed";
    }
}
