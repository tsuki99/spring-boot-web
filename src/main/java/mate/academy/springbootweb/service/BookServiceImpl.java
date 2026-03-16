package mate.academy.springbootweb.service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import mate.academy.springbootweb.dto.BookDto;
import mate.academy.springbootweb.dto.CreateBookRequestDto;
import mate.academy.springbootweb.exception.EntityNotFoundException;
import mate.academy.springbootweb.mapper.BookMapper;
import mate.academy.springbootweb.model.Book;
import mate.academy.springbootweb.repository.BookRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private static final String NOT_FOUND_ENTITY_MESSAGE = "Can't find book by id: ";

    @Override
    public BookDto save(CreateBookRequestDto requestDto) {
        Book book = bookMapper.toModel(requestDto);
        return bookMapper.toDto(bookRepository.save(book));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findBookById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(NOT_FOUND_ENTITY_MESSAGE + id)));
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDto updateById(Long id, BookDto bookDto) {
        Book existingBook = bookRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(NOT_FOUND_ENTITY_MESSAGE + id));

        updateEntityFromDto(existingBook, bookDto);

        return bookMapper.toDto(bookRepository.save(existingBook));
    }

    private void updateEntityFromDto(Book book, BookDto bookDto) {
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        book.setIsbn(bookDto.getIsbn());
        book.setPrice(bookDto.getPrice());
        book.setDescription(bookDto.getDescription());
        book.setCoverImage(bookDto.getCoverImage());
    }
}
