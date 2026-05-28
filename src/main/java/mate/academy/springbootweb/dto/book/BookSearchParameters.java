package mate.academy.springbootweb.dto.book;

public record BookSearchParameters(String[] titleParts, String[] authors, String[] isbns) {
}
