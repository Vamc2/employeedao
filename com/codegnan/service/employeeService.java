package com.codegnan.service;

import java.util.*;

import com.codegnan.exceptions.employeeNotFoundException;
import com.codegnan.model.employee;

public interface employeeService {
    void addEmployee(employee employee);

    List<employee> getAllEmployees();

    employee getEmployeeById(int id) throws employeeNotFoundException;

    void updateEmployee(employee employee) throws employeeNotFoundException;

    void deleteEmployeeById(int id) throws employeeNotFoundException;

}