package com.codegnan.exceptions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.codegnan.dao.employeeDao;
import com.codegnan.model.employee;
import com.codegnan.util.dbConnectionUtil;

public class employeeNotFoundException extends Exception {
    public employeeNotFoundException(String msg) {
        super(msg);
    }
}
