package com.github.nossomercadolivre.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueNameCategoryValidator.class)
public @interface UniqueNameCategory {
    String message() default "{com.github.nossomercadolivre.uniquenamecategory.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}


