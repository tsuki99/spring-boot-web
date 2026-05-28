package mate.academy.springbootweb.service;

import java.util.List;
import mate.academy.springbootweb.dto.book.BookDto;
import mate.academy.springbootweb.dto.book.BookSearchParameters;
import mate.academy.springbootweb.dto.book.CreateBookRequestDto;

public interface BookService {
    BookDto save(CreateBookRequestDto requestDto);

    List<BookDto> findAll();

    BookDto findBookById(Long id);

    void deleteById(Long id);

    BookDto updateById(Long id, CreateBookRequestDto requestDto);

    List<BookDto> search(BookSearchParameters searchParameters);
}
