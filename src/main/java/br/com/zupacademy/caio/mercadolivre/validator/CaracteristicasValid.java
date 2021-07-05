package br.com.zupacademy.caio.mercadolivre.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {CaracteristicasValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface CaracteristicasValid {
    String message() default "Deve conter pelo menos 3 elementos.";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
