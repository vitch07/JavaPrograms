package connection;

import java.sql.*;

import java.sql.DriverManager;
import java.sql.SQLException;

public class DBmanager {
    public static final String url = "jdbc:postgresql://localhost:5432/northernarc";
    public static final String user = "postgre";
    public static final String password = "12345";

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }


}
