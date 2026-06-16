package connection;

import dao.BookDaoImpl;
import dao.BookJdbcDao;
import entity.Book;

import java.util.Scanner;

public class MainBook {
    private static BookJdbcDao  bookdao = new BookDaoImpl();

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("enter book title, author, publisher");
        Book book = new Book(sc.nextLine(),sc.nextLine(),sc.next());



    }
}
