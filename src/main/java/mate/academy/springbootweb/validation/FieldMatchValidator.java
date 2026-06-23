package mate.academy.springbootweb.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;
import java.util.Objects;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String first;
    private String second;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.first = constraintAnnotation.first();
        this.second = constraintAnnotation.second();

    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        if (object == null) {
            return true;
        }

        try {
            Field f1 = object.getClass().getDeclaredField(first);
            Field f2 = object.getClass().getDeclaredField(second);

            f1.setAccessible(true);
            f2.setAccessible(true);

            Object v1 = f1.get(object);
            Object v2 = f2.get(object);

            boolean isObjectsEquals = Objects.equals(v1, v2);

            if (!isObjectsEquals) {
                constraintValidatorContext.disableDefaultConstraintViolation();
                constraintValidatorContext.buildConstraintViolationWithTemplate(
                        constraintValidatorContext.getDefaultConstraintMessageTemplate()
                        )
                        .addPropertyNode(second)
                        .addConstraintViolation();
            }

            return isObjectsEquals;

        } catch (Exception e) {
            return false;
        }
    }

}
