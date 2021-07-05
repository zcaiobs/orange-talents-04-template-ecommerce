package br.com.zupacademy.caio.mercadolivre.validator;

import br.com.zupacademy.caio.mercadolivre.produto.Caracteristicas;
import br.com.zupacademy.caio.mercadolivre.produto.CaracteristicasRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CaracteristicasValidator implements ConstraintValidator<CaracteristicasValid, List<CaracteristicasRequest>> {

    @Override
    public boolean isValid(List<CaracteristicasRequest> caracteristicasRequests, ConstraintValidatorContext constraintValidatorContext) {
        return caracteristicasRequests.size() >= 3;
    }
}
