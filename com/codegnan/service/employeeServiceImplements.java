package com.codegnan.service;

import java.util.List;

import com.codegnan.dao.employeeDao;
import com.codegnan.dao.employeeDaoImplements;
import com.codegnan.exceptions.employeeNotFoundException;
import com.codegnan.model.employee;

public class employeeServiceImplements implements employeeService {

    employeeDao dao = new employeeDaoImplements();

    public void addEmployee(employee employee) {
        dao.save(employee);
    }

    public List<employee> getAllEmployees() {
        return dao.findAll();
    }

    public employee getEmployeeById(int id) throws employeeNotFoundException {
        return dao.findById(id);
    }

    public void updateEmployee(employee employee) throws employeeNotFoundException {
        dao.update(employee);
    }

    public void deleteEmployeeById(int id) throws employeeNotFoundException {
        dao.deleteById(id);
    }
}
