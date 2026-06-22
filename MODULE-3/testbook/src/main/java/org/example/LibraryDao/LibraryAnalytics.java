package org.example.LibraryDao;


import org.example.model.Book;

import java.util.*;
import java.util.stream.Collectors;

public class LibraryAnalytics {
    private Map<String, Book> books = new HashMap<>();

    public void loadBooks(List<String> records) {
        records.stream()
                .map(record -> record.split("\\|"))
                .filter(fields -> fields.length == 6)
                .forEach(fields -> {
                    String bookId = fields[0].trim();
                    String title = fields[1].trim();
                    String author = fields[2].trim();
                    String category = fields[3].trim();
                    int borrowCount = Integer.parseInt(fields[4].trim());
                    double rating = Double.parseDouble(fields[5].trim());
                    if (bookId.isEmpty() || title.isEmpty() || author.isEmpty() || category.isEmpty() || borrowCount < 0 ||
                    rating < 0 || rating > 5) {
                        return;
                    }
                    Book newBook = new Book(bookId, title, author, category, borrowCount, rating);
                    books.compute(bookId,(key,existingBook) -> {
                        if (existingBook == null ){
                            return newBook;
                        }
                        return Comparator .comparingDouble(Book::getRating)
                                .thenComparingInt(Book::getBorrowCount)
                                .thenComparing(Book::getTitle)
                                .compare(newBook, existingBook) > 0 ? newBook : existingBook;
                    });
                });
    }

    public List<Book> topRatedBooks(int n) {
        return books.values().stream()
                .sorted(
                        Comparator .comparingDouble(Book::getRating).reversed()
                                .thenComparingInt(Book::getBorrowCount).reversed()
                                .thenComparing(Book::getTitle)
                                .reversed()
                ) .limit(n).collect(Collectors.toList());

    }

    public Map<String, Double> averageRatingByCategory() {
        return books.values().stream()
                .collect(Collectors.groupingBy(Book::getCategory,
                        TreeMap::new,
                        Collectors.collectingAndThen(Collectors.averagingDouble(Book::getRating),
                                avg -> Math.round(avg * 100.0)/100.0)));
    }

    public Optional<Book> mostBorrowedBook() {
        return books.values().stream()
                .max( Comparator .comparingInt(Book::getBorrowCount)
                        .thenComparingDouble(Book::getRating)
                        .thenComparing(Book::getBookId,Comparator.reverseOrder()));
    }

    public Set<String> authorsWithMultipleCategories() {
        return books.values().stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.mapping(Book::getCategory,
                        Collectors.toSet())))
                .entrySet()
                .stream() .filter(e -> e.getValue().size() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Map<String,List<Book>> groupBooksByAuthor() {
        return books.values().stream()
                .collect ( Collectors.groupingBy(Book::getAuthor,
                        LinkedHashMap::new,
                        Collectors.collectingAndThen(
                                        Collectors.toList(),
                                list -> {
                                    list.sort(Comparator .comparingDouble(Book::getRating).reversed()
                                            .thenComparing( Comparator.comparingInt(Book::getBorrowCount).reversed()));
                                    return list;
                                }
                        )
                ));
    }

    public List<String> suspiciousBooks() {
            return books.values().stream()
                    .filter(book -> book.getRating() < 2.0 && book.getBorrowCount() > 100)
                    .map(Book::getBookId)
                    .sorted()
                    .collect(Collectors.toList());

    }
    public Map<String, Map<String,Book>>  categoryWiseTopRatedBookByEachAuthor()  {

        return books.values()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Book::getCategory,
                                TreeMap::new,
                                Collectors.groupingBy(
                                        Book::getAuthor,
                                        TreeMap::new,
                                        Collectors.collectingAndThen(
                                                Collectors.maxBy(
                                                        Comparator
                                                                .comparingDouble(
                                                                        Book::getRating
                                                                )

                                                                .thenComparingInt(
                                                                        Book::getBorrowCount
                                                                )

                                                                .thenComparing(
                                                                        Book::getTitle,
                                                                        Comparator.reverseOrder()
                                                                )
                                                ),

                                                Optional::get
                                        )
                                )
                        )
                );
    }
}


