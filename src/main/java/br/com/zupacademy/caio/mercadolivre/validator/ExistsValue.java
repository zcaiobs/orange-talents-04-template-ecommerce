package br.com.zupacademy.caio.mercadolivre.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = {ExistsCategoriaValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistsValue {

    String message() default "Valor de atributo não encontrado.";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
    String fieldName();
    Class<?> domainClass();
}