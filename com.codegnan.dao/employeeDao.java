import com.codegnan.model.employee;

import java.util.*;

public interface employeeDao {
    void save(employee employee);

    List<employee> findAll();

    employee findById(int id) throws employeeNotFoundException;

    void update(employee employee) throws employeeNotFoundException;

    void deleteById(int id) throws employeeNotFoundException;

}
