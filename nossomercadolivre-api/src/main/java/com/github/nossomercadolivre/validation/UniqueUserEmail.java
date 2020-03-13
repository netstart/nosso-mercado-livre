package com.github.nossomercadolivre.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUserEmailValidator.class)
public @interface UniqueUserEmail {
    String message() default "{com.github.nossomercadolivre.uniqueuseremail.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}


