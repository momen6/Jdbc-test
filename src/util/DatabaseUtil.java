package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String DBURL = "jdbc:mysql://127.0.0.1:3306/demo";
    private static final String USER = "student";
    private static final String PASWWORD = "student";

    public DatabaseUtil() {
    }

    public static Connection getConnection() throws SQLException{
        Connection connection = null;
        connection = DriverManager.getConnection(DBURL,USER,PASWWORD);
        return connection;
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.close();
    }
}
