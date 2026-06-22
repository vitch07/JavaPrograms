package fullNbfcJdbc.connection;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
public class DBmanager {
    private final String db_url = "jdbc:postgresql://localhost:5432/northernarc";
    private final String username ="postgres";
    private final String password = "12345";

    public Connection getConnection(){
        try{
            return DriverManager.getConnection(db_url,username,password);
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
    public void closeConnection(Connection connection){
        if(connection != null){
        try{
            connection.close();
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }}

}
