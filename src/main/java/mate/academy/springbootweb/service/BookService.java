package mate.academy.springbootweb.service;

import java.util.List;
import mate.academy.springbootweb.model.Book;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
