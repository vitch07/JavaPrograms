package fullNbfcJdbc.EmiDao;

import fullNbfcJdbc.connection.DBmanager;
import fullNbfcJdbc.entity.Emi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmiDaoImpl implements EmiDao {
    private DBmanager dBmanager;

    List<Emi> list = new ArrayList<>();
    public EmiDaoImpl(DBmanager dBmanager) {
        this.dBmanager = dBmanager;
        Connection conn = this.dBmanager.getConnection();
        String sql = "Create table if not exists emi_table(emi_id SERIAL primary key," +
                "loan_id int ,due_date DATE, amount Decimal(10,2), paid Boolean)";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        try {
            stmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


//    public EmiDaoImpl() {
//        try(Connection conn = dBmanager.getConnection()){
//            String sql = "Create table if not exists emi_table(emi_id SERIAL primary key," +
//                    "loan_id int ,due_date DATE, amount Decimal(10,2), paid Boolean ";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            stmt.execute();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public void save(Emi emi) {
        try(Connection conn = dBmanager.getConnection()){
            String sql1 = "Insert into emi_table(emi_id,loan_id,due_date,amount,paid) " +
                    "values(?,?,?,?,?) ";
            PreparedStatement stmt = conn.prepareStatement(sql1);
            stmt.setInt(1,emi.getEmiId());
            stmt.setInt(2,emi.getLoanId());
            stmt.setDate(3, (Date) emi.getDueDate());
            stmt.setDouble(4,emi.getAmount());
            stmt.setBoolean(5,emi.isPaid());
            stmt.executeUpdate();
        }
         catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Emi findById(int emi_id) {
        try(Connection conn = dBmanager.getConnection()){
            String sql = "Select * from emi_table where emi_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,emi_id);
            stmt.executeUpdate();
        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Emi> findall() {
        try(Connection conn = dBmanager.getConnection()){
            String sql = "Select * from emi_table";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                list.add(new Emi(rs.getInt("emi_id"), rs.getInt("loan_id"), rs.getDate("due_date"),
                        rs.getDouble("amount"), rs.getBoolean("paid")));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Emi emi) {
        try(Connection conn = dBmanager.getConnection()){
            String sql = "update emi_table set loan_id = ?, due_date = ?,amount = ?,paid = ? where emi_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,emi.getLoanId());
            stmt.setDate(2,(Date)emi.getDueDate());
            stmt.setDouble(3,emi.getAmount());
            stmt.setBoolean(4,emi.isPaid());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try(Connection conn = dBmanager.getConnection()){
            String sql = "Delete from emi_table where emi_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1,id);
            stmt.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void markAsPaid(int id,boolean paid) {
        try(Connection conn = dBmanager.getConnection()){
            String sql = "Update emi_table set paid = ? where emi_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setBoolean(1,paid);
            stmt.setInt(2,id);
            stmt.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void findPendingsEmis() {
        try(Connection conn = dBmanager.getConnection()){
            String sql = "Select * from emi_table where paid = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setBoolean(1,false);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                System.out.println(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
