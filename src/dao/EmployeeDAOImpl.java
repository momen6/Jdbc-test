package dao;

import dao.EmployeeDAO;
import model.Employee;
import util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public Employee get(int id) throws SQLException {
        Connection connection = DatabaseUtil.getConnection();
        Employee employee = null;
        String sql = "Select * " +
                "from employees where id = ?;";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int oid = resultSet.getInt("id");
            String employeeFName = resultSet.getString("first_name");
            String empLastName = resultSet.getString("last_name");
            String dep = resultSet.getString("department");
            String email = resultSet.getString("email");
            Double salary = resultSet.getDouble("salary");
            employee = new Employee(oid, employeeFName,empLastName,dep,email,salary);
        }

        return employee;
    }

    @Override
    public List<Employee> getAll() throws SQLException {
        Connection connection = DatabaseUtil.getConnection();
        String sql = "select * from employees;";
        List<Employee> employeeList = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            employeeList.add(this.fillEmployee(resultSet));
        }
        return employeeList;
    }

    @Override
    public int save(Employee employee) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Employee employee) throws SQLException {
        Connection connection = DatabaseUtil.getConnection();
        String sql = "insert into employees (id,first_name,last_name,department,salary ) " +
                "values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,employee.getId());
        preparedStatement.setString(2, employee.getFirstName());
        preparedStatement.setString(3, employee.getLastName());
        preparedStatement.setString(4,employee.getDepartment());
        preparedStatement.setDouble(5,employee.getSalary());

        int result = preparedStatement.executeUpdate();

        DatabaseUtil.closePreparedStatement(preparedStatement);
        return result;
    }

    @Override
    public int update(Employee employee) throws SQLException {
        Connection connection = DatabaseUtil.getConnection();
        String sql = "Update Employees " +
                "set salary = ? " +
                "where id= ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1,employee.getSalary());
        preparedStatement.setInt(2,employee.getId());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    @Override
    public int delete(Employee employee) throws SQLException {
        Connection connection = DatabaseUtil.getConnection();
        String sql = "delete from employees " +
                "where id = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,employee.getId());
        int result = preparedStatement.executeUpdate();
        return result;
    }

    private Employee fillEmployee(ResultSet resultSet) throws SQLException {
        return new Employee(resultSet.getInt("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getString("department"),
                    resultSet.getDouble("salary"));
    }
}
