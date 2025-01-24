package com.example.retornosAPI.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GreaterOrEqualsToZeroValidator implements ConstraintValidator<GreaterThanZero, Number> {

    @Override
    public void initialize (GreaterThanZero constraintAnnotation){
    }
    @Override
    public boolean isValid(Number value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null) {
            return true;
        }
        return value.doubleValue() >= 0;
    }
}
