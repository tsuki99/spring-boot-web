package mate.academy.springbootweb.mapper;

import mate.academy.springbootweb.config.MapperConfig;
import mate.academy.springbootweb.dto.book.BookDto;
import mate.academy.springbootweb.dto.book.CreateBookRequestDto;
import mate.academy.springbootweb.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto requestDto);

    void updateBookFromDto(CreateBookRequestDto dto,
                           @MappingTarget Book book);
}
