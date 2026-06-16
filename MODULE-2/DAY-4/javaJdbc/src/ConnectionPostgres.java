import java.sql.*;

public class ConnectionPostgres {
    public static void main(String[] args){
        String url = "jdbc:postgresql://localhost:5432/northernarc";
        String user = "postgres";
        String password = "12345";

        try(Connection conn = DriverManager.getConnection(url,user,password)){
////            System.out.println("Connection connected Successfully");
//            String sql =
//                    "Create table if not exists person (" +
//                            "emp_id int primary key," +
//                            "name varchar(20), designation varchar(20) )";

            String sql = " Insert into person(emp_id,name,designation) values (1011,'vishnu','HR'),(1103,'balaji','accounts')";
            String sql1 = "select * from person";
//            String sql1 = "select ";

            PreparedStatement stmt = conn.prepareStatement(sql1);
            ResultSet res = stmt.executeQuery();
                System.out.println("query executed successfully ");
                while(res.next()){
                    System.out.println(res.getString(2)+ " " + res.getString(3));
                }
        }
        catch(SQLException e){
            System.err.println("Failed to connect ");
            e.printStackTrace();
        }
    }
}
