import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import com.codegnan.dao;
import com.codegnan.model;
import com.codegnan.util;

public class employeeNotFoundException implements employeeDao {
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
        return null;
    }
}
