package org.example.LibraryDao;

import java.awt.print.Book;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface LibraryDao {
    void loadBooks(List<String> records);
    List<Book> topRatedBooks(int n);
    Map<String, Double> averageRatingByCategory();
    Optional<Book> mostBorrowedBook();
    Set<String> authorsWithMultipleCategories();
    Map<String,List<Book>> groupBooksByAuthor();
    List<String> suspiciousBooks();
    public Map<String, Map<String,Book>>  categoryWiseTopRatedBookByEachAuthor();
}
