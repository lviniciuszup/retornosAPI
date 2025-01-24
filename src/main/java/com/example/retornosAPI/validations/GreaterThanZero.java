package com.example.retornosAPI.validations;

import com.example.retornosAPI.dtos.ProductDTO;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GreaterThanZeroValidator.class)
public @interface GreaterThanZero {
    String message() default "O número precisa ser maior que zero";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
