package fullpackageDaoJdbc.connection.connection;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBManager {
    private final String db_url = "jdbc:postgresql://localhost:5432/northernarc";
    private final String username = "postgres";
    private final String password = "12345";

    public Connection getConnection(){
        try{
            return DriverManager.getConnection(db_url,username,password);
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection(Connection connection){
            if(connection != null){
                try{
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error closing the connection " + e.getMessage());
                }
            }
        }
    }

