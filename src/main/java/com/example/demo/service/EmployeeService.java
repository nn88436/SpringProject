package com.example.demo.service;

import com.example.demo.controller.EmployeeController;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.List;

@Service
public class EmployeeService {

    private  Logger logger = LoggerFactory.getLogger(EmployeeService.class);
    private EmployeeRepository employeeRepository;

    public EmployeeService(DataSource dataSource)
    {

        employeeRepository=new EmployeeRepository(dataSource);

    }

    public List<Employee> validateAndReturnEmployeeList()
    {
        logger.info("EmployeeService.getEmployeeList invoked");
        return employeeRepository.employeeListFromDb();
    }
}
