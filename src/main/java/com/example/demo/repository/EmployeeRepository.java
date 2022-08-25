package com.example.demo.repository;

import com.example.demo.controller.EmployeeController;
import com.example.demo.model.Employee;
import org.jdbi.v3.core.Jdbi;

import org.jdbi.v3.core.mapper.reflect.FieldMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class EmployeeRepository {

    private  Logger logger = LoggerFactory.getLogger(EmployeeRepository.class);
    private Jdbi database;
    public EmployeeRepository(DataSource dataSource)
    {

        database=Jdbi.create(dataSource);

    }

    public List<Employee> employeeListFromDb()
    {
        List<Employee> employeeList= database.withHandle(handle -> {
            handle.registerRowMapper(FieldMapper.of(Employee.class));
            return handle.select("select * from employee_data").mapTo(Employee.class).list();
        });
        return employeeList;
    }
}
