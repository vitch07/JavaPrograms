package doaNBFC;

import connection.DBManager;
import entity.Repayment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepaymentDoaImpl implements RepaymentDao{

    @Override
    public void save(Repayment repayment) {
        try(Connection conn = DBManager.getConnection()){
                String sql = "Insert into repayment(loan_id, amount_paid, due_date, paid_date) values"
                    + "(?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,repayment.getLoanId());
            ps.setDouble(2,repayment.getAmountPaid());
            ps.setDate(3, (Date) repayment.getDueDate());
            ps.setDate(4, (Date) repayment.getPaidDate());
            ps.executeUpdate();

        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Repayment> findByLoan(int loanId) {
        List<Repayment> list = new ArrayList<>();
        try(Connection conn = DBManager.getConnection()){
            String sql1 = "Select * from repayment where loan_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql1);
            stmt.setInt(1,loanId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                list.add(new Repayment(rs.getInt("loan_id"),
                    rs.getDouble("amount_paid"),
                        rs.getDate("due_Date"),
                        rs.getDate("paid_Date")
                ));
            }

        } catch (SQLException | RuntimeException e) {
            throw new RuntimeException("SQL EXception | RUntime exception " + e.getMessage());
        }
        return List.of();
    }

    @Override
    public int calculateOverdueDays(int loanId) {
        int OverDueDays = 0;
        try(Connection conn = DBManager.getConnection()){
            String sql2 = "Select MAX(CURRENT_DATE - due_date) as over_Due from repayment" +
                    "where loan_id = ? and paid_date IS NULL";

            PreparedStatement stmt = conn.prepareStatement(sql2);
            stmt.setInt(1,loanId);

            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                OverDueDays = rs.getInt("overdue");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Math.max(OverDueDays,0);
    }

    @Override
    public String classifyLoanStatus(int loanId) {
        int days  = calculateOverdueDays(loanId);
        if (days == 0) return "current";
        else if (days <= 30) return "SMA1";
        else if (days >= 31) return "SMA2";
        else return "NPA";
    }
}
