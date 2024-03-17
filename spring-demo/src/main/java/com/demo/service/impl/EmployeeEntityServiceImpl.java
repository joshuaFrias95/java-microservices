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
import java.util.stream.Collectors;

@Service("EmployeeEntityServiceImpl")
public class EmployeeEntityServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {

        if (employee.getEmployeeID() == null || employee.getEmailId().isEmpty()) {
            employee.setEmployeeID(UUID.randomUUID().toString().substring(0,6));
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {

        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        List<Employee> employees = employeeEntityList.stream()
                .map(employeeEntity -> {
                    Employee employee = new Employee();
                    BeanUtils.copyProperties(employeeEntity, employee);
                    return employee;
                })
                .collect(Collectors.toList());

        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {

        EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
        Employee employee = new Employee();

        BeanUtils.copyProperties(employeeEntity, employee);

        return employee;
    }

    @Override
    public String deleteEmployeeByid(String id) {
        return null;
    }
}
