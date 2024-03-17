package com.demo.service.impl;

import com.demo.entity.EmployeeEntity;
import com.demo.model.Employee;
import com.demo.repository.EmployeeRepository;
import com.demo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service("EmployeeEntityServiceImpl")
public class EmployeeEntityServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {

        if (employee.getEmployeeID() == null || employee.getEmailId().isEmpty()) {
            employee.setEmployeeID(UUID.randomUUID().toString());
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return null;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return null;
    }

    @Override
    public String deleteEmployeeByid(String id) {
        return null;
    }
}
