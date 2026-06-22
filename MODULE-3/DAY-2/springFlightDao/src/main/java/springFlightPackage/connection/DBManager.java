package springFlightPackage.connection;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBManager {
    private static final String db_url = "jdbc:postgresql://localhost:5432/northernarc";
    private static final String username ="postgres";
    private static final String password = "12345";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(db_url,username,password);
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeConnection(Connection connection){
        if(connection != null){
        try{
            connection.close();
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }}

}
