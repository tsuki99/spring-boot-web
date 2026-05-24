package mate.academy.springbootweb.dto.error;

import java.util.List;

public record ErrorResponse(List<FieldErrorDto> errors) {

}
