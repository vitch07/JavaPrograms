package dao;

import Books.Books;

public interface BookDao {
    public void save(Books book);
    public Books findById(int id);
    public void deleteById(int id);
    public void update(Books book);
    public void deleteAll();
    public Iterable<Books> findAll();
    public Iterable<Books> findByAuthor(String author);
    public Iterable<Books> sortByTitleAsc();
    public Iterable<Books> sortByTitleDsc();

}
