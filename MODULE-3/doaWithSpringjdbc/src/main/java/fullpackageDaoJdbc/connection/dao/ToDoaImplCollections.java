package fullpackageDaoJdbc.connection.dao;

import fullpackageDaoJdbc.connection.connection.DBManager;
import fullpackageDaoJdbc.connection.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


public class ToDoaImplCollections implements TodoDao{

    Map<Integer,Todo> maps = new HashMap<>();
    private  final DBManager dbmanager;
    Scanner sc;
    public ToDoaImplCollections(DBManager dbmanager){
        this.dbmanager = dbmanager;
    }
    @Override
    public void save( Todo todo) {
           try(Connection conn = dbmanager.getConnection()){
               String sql = "Insert into todo (todo_id,task,done) values (?,?,?)";
               PreparedStatement stmt = conn.prepareStatement(sql);
               stmt.setInt(1,todo.getTodoId());
               stmt.setString(2, todo.getTask());
               stmt.setBoolean(3,todo.getStatus());
               stmt.executeUpdate();
           } catch (RuntimeException | SQLException e) {
               throw new RuntimeException(e);
           }

    }

    @Override
    public void deleteById(int id) {
        try(Connection conn = dbmanager.getConnection()){
            String sql1 = "Delete from todo where todo_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql1);
            stmt.setInt(1,id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Todo findbyId(int id) {
        try (Connection conn = dbmanager.getConnection()) {
            String sql2 = "Select * from todo where todo_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql2);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                return new Todo(rs.getInt("todo_id"),
                        rs.getString("task"),
                        rs.getBoolean("done"));
            }
           return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Todo update(Todo t) {
        try(Connection conn = dbmanager.getConnection()){
            String sql2 = "Update todo set task = ?, done = ? where todo_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql2);
            stmt.setString(1,t.getTask());
            stmt.setBoolean(2,t.getStatus());
            stmt.setInt(3,t.getTodoId());
            ResultSet rs = stmt.executeQuery();
            return new
                    Todo(rs.getInt("todo_id"),rs.getString("task")
                    ,rs.getBoolean("done"));
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public void deleteall() {
        try(Connection conn = dbmanager.getConnection()){
            String sql3 = "Delete * from todo";
            PreparedStatement stmt = conn.prepareStatement(sql3);
            stmt.executeUpdate();
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Map<Integer, Todo> findall() {
        List<Todo> list = new ArrayList<>();
        try(Connection conn = dbmanager.getConnection()){
            String sql3 = "Select * from todo";
            PreparedStatement stmt = conn.prepareStatement(sql3);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                list.add(new Todo(rs.getInt("todo_id"),rs.getString("task"),
                        rs.getBoolean("done")));
            }
            return list.stream().collect(Collectors.toMap(Todo::getTodoId
                                                    , todo -> todo)); // Todo todo -> is internally inferred
        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
