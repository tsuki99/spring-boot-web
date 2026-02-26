package mate.academy.springbootweb.repository;

import java.util.List;
import mate.academy.springbootweb.model.Book;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}
