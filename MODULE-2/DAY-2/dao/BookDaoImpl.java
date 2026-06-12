package dao;

import Books.Books;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class BookDaoImpl {
    private ArrayList<Books> booklist;
    BookDaoImpl (){
        booklist = new ArrayList<>();
    }
    public void save(Books book){
        booklist.add(book);
    }
    public Books findById(int id){
        for(Books b:booklist){
            if (b.getId() == id){
                return b;
            }
        }
        return null;
    }
    public void deleteAll(){
        booklist.clear();
    }

    public void update(Books book) {
        for(Books b1: booklist){
            if (b1.getId() == book.getId()){
                b1.setAuthor(book.getAuthor());
                b1.setName(book.getName());
            }
        }
    }
    public Iterable<Books> sortByTitleAsc(){
        Collections.sort(booklist, new Comparator<Books>() {
            public int compare(Books b1, Books b2){
                return b1.getAuthor().compareToIgnoreCase(b2.getAuthor());
            }
        });
        return booklist;
    }
    public Iterable<Books> sortByTitleDesc(){
            Collections.sort(booklist, new Comparator<Books>() {
                @Override
                public int compare(Books o1, Books o2) {
                    return o2.getAuthor().compareToIgnoreCase(o1.getAuthor()) ;
                }
            });
            return booklist;
    }
}