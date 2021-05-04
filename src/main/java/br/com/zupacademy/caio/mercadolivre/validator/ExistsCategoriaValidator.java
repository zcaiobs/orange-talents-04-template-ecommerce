package br.com.zupacademy.caio.mercadolivre.validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsCategoriaValidator implements ConstraintValidator<ExistsValue, Long> {

    String domainAttribute;
    Class<?> klass;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(ExistsValue params) {
        domainAttribute = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(value == 0) return true;
        return !(entityManager
                .createQuery("select c from "+klass.getName()+" c where "+domainAttribute+" = :value")
                .setParameter("value", value)
                .getResultList().isEmpty());
    }
}
