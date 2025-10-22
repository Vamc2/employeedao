package com.codegnan.controller;

import java.util.*;

import com.codegnan.exceptions.employeeNotFoundException;
import com.codegnan.model.employee;
import com.codegnan.service.employeeService;
import com.codegnan.service.employeeServiceImplements;

public class employeeApp {
    public static void main(String args[]) {
        employeeService service = new employeeServiceImplements();

        // add
        service.addEmployee(new employee(111, "name", "dept", 100));
        service.addEmployee(new employee(112, "name1", "dept1", 1001));
        service.addEmployee(new employee(113, "name2", "dept2", 1002));
        service.addEmployee(new employee(114, "name3", "dept3", 1003));
        service.addEmployee(new employee(115, "name4", "dept4", 1004));

        System.out.println("employees saved successfully");

        // get all employee
        List<employee> allEmps = service.getAllEmployees();
        for (employee all : allEmps) {
            System.out.println(all);
        }

        // find by id
        System.out.println("fetch empl with id 103");
        try {
            employee fetEmployee = service.getEmployeeById(103);
            System.out.println("emp found:" + fetEmployee);
        } catch (employeeNotFoundException e) {
            e.printStackTrace();
        }

        // update
        System.out.println("updating emp with id 101");
        try {
            service.updateEmployee(new employee(101, "new name", "new dept", 10));
            System.out.println("employee succefully updated");
        } catch (employeeNotFoundException e) {
            e.printStackTrace();
        }

        // delet by id
        System.out.println("deleting emp with id 110");
        try {
            service.deleteEmployeeById(110);
        } catch (employeeNotFoundException e) {
            e.printStackTrace();
        }

    }
}
