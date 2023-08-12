import dao.EmployeeDAOImpl;

import java.sql.SQLException;

public class MyJDBC {

    public static void main(String[] args) throws SQLException {
//        model.Employee employee = new model.Employee(14,"momen","magdy","CS","momenmagdy464@gmail.com",10000.00);
//        System.out.println(employee);

//        Connection connection = null;
//        try {
//            connection = Database.getConnection();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        if (connection != null)
//            System.out.println("success");

//        dao.EmployeeDAO employeeDAO = new dao.EmployeeDAOImpl();
//
//        model.Employee employee = employeeDAO.get(5);
//
//        System.out.println(employee);
//
//        dao.EmployeeDAO employeeDAO = new dao.EmployeeDAOImpl();
//
//        model.Employee employee = new model.Employee(15,"maged","Magdy","CS","maged@gmail.com",1500.00);
//        employeeDAO.insert(employee);
//        employeeDAO.delete(employee);

        EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

        System.out.println(employeeDAO.getAll());
    }
}
