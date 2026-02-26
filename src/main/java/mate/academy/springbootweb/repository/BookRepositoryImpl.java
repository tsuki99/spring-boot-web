package mate.academy.springbootweb.repository;

import java.util.ArrayList;
import java.util.List;
import mate.academy.springbootweb.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final List<Book> books = new ArrayList<>();

    @Override
    public Book save(Book book) {
        books.add(book);
        return book;
    }

    @Override
    public List<Book> findAll() {
        return books;
    }
}
