package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    public static final String db_url = "jdbc:postgresql://localhost:5432/northernarc";
    public static final String user = "postgres";
    public static final String password = "12345";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(db_url,user,password);
        }
         catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closeConnection(Connection connection){
        if(connection != null){
            try{
                connection.close();
            }catch(SQLException e){
                System.out.println("Error closing connection " + e.getMessage());
            }
        }
    }
}
