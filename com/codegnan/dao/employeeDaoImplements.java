package com.codegnan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.codegnan.exceptions.employeeNotFoundException;
import com.codegnan.model.employee;
import com.codegnan.util.dbConnectionUtil;

public class employeeDaoImplements implements employeeDao {
    public void save(employee employee) {
        String sql = "insert into employees(id,name,department,salary) values(?,?,?,?)";
        try (Connection con = dbConnectionUtil.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, employee.getId());
            pst.setString(2, employee.getName());
            pst.setString(3, employee.getDepartment());
            pst.setDouble(4, employee.getSalary());

            pst.executeUpdate();
            System.out.println("employee saved: " + employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<employee> findAll() {
        String sql = "select * from employees";
        List<employee> employees = new ArrayList<>();
        try (Connection con = dbConnectionUtil.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            ResultSet res = pst.executeQuery();

            while (res.next()) {
                employee emp = new employee();
                emp.setId(res.getInt(1));
                emp.setName(res.getString(2));
                emp.setDepartment(res.getString(3));
                emp.setSalary(res.getDouble(4));

                employees.add(emp);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public employee findById(int id) throws employeeNotFoundException {
        String sql = "select * from employees where id=?";
        employee emp = new employee();
        try (Connection con = dbConnectionUtil.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet res = pst.executeQuery();
            if (res.next()) {
                emp.setId(res.getInt(1));
                emp.setName(res.getString(2));
                emp.setDepartment(res.getString(3));
                emp.setSalary(res.getDouble(4));

            } else {
                throw new employeeNotFoundException("id not found " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return emp;

    }

    public void update(employee employee) throws employeeNotFoundException {
        String sql = "update employees set name=?,department=?,salary=? where id=?";
        try (Connection con = dbConnectionUtil.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, employee.getName());
            pst.setString(2, employee.getDepartment());
            pst.setDouble(3, employee.getSalary());
            pst.setInt(4, employee.getId());

            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("updated successfully:" + employee.getId() + "\t" + employee.getName() + "\t"
                        + employee.getDepartment() + "\t" + employee.getSalary());
            } else {
                throw new employeeNotFoundException("id not found " + employee.getId());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteById(int id) throws employeeNotFoundException {
        String sql = "delete from employees where id=?";
        try (Connection con = dbConnectionUtil.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            int rowsAffected = pst.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("employee with id " + id + " has been deleted successfully");
            } else {
                throw new employeeNotFoundException("id not found " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
