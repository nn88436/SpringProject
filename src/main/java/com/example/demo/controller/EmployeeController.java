package com.example.demo.controller;

import com.example.demo.model.Employee;


import com.example.demo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.sql.DataSource;
import java.util.List;

@RestController
public class EmployeeController {

    private  Logger logger = LoggerFactory.getLogger(EmployeeController.class);


    private EmployeeService employeeService;

    public EmployeeController(DataSource dataSource)
    {
        employeeService=new EmployeeService(dataSource);
    }

     @GetMapping("/employeeList")
    public List<Employee> getEmployeeList()
    {
        logger.info("EmployeeController.getEmployeeList invoked");
        return employeeService.validateAndReturnEmployeeList();
    }
}
