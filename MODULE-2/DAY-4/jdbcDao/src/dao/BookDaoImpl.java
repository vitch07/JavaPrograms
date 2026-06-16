package dao;

import connection.DBmanager;
import entity.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookDaoImpl implements BookJdbcDao{

    @Override
    public int save(Book b) {
        try{
            Connection conn = DBmanager.getConnection();
            String sql = "Insert into book (title, author, publisher) values (?,?,?)";
            PreparedStatement pt = conn.prepareStatement(sql);
            pt.setString(1,b.getTitle());
            pt.setString(2,b.getAuthor());
            pt.setString(2, b.getPublisher());

        }catch(SQLException e){
            System.out.println("Connection issue ..");
        }

        return 0;
    }

    @Override
    public Book findbyId(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void update(Book book) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public Collection<Book> findAll() {
        ArrayList<Book> books = new ArrayList<>();

        try (Connection conn = DBmanager.getConnection()) {

            String sql = "SELECT * FROM book";
            PreparedStatement statement = conn.prepareStatement(sql);

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {

                Book book = new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher")
                );

                books.add(book);
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }

        return books;
    }


    @Override
    public Collection<Book> findByAuthor(String author) {
        ArrayList<Book> books = new ArrayList<>();

        try (Connection conn = DBmanager.getConnection()) {
            String sql = "SELECT * FROM book WHERE author = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, author);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                books.add(mapToBook(rs));
            }

        } catch (SQLException e) {
            System.out.println("Issue in connectivity: " + e.getMessage());
        }

        return books;
    }


    @Override
    public Collection<Book> findByTitle(String title) {
        return List.of();
    }

    @Override
    public Collection<Book> sortByTitleAsc() {
        return List.of();
    }

    @Override
    public Collection<Book> sortByTitleDesc() {
        return List.of();
    }
}
