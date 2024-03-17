package com.demo.controller.v2;

import com.demo.model.Employee;
import com.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2/employees")
public class EmployeeV2Controller {

    @Autowired
    @Qualifier("EmployeeEntityServiceImpl")
    private EmployeeService EmployeeEntityServiceImpl;

    @PostMapping
    public Employee save(@RequestBody Employee employee) {

        return EmployeeEntityServiceImpl.save(employee);
    }
}
