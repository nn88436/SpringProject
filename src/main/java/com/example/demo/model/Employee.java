package com.example.demo.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

import java.util.Objects;

public class Employee {
    @ColumnName("employee_num")
    private Integer employeeNum;
    @ColumnName("employee_name")
    private String employeeName;

    public Integer getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(Integer employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeNum, employee.employeeNum) && Objects.equals(employeeName, employee.employeeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeNum, employeeName);
    }
}
