package com.github.nossomercadolivre.validation;

import com.github.nossomercadolivre.CategoryRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class UniqueNameCategoryValidator implements ConstraintValidator<UniqueNameCategory, String> {

    private final CategoryRepository categoryRepository;

    public UniqueNameCategoryValidator(final CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public boolean isValid(String nameOfCategory, ConstraintValidatorContext context) {
        return isValid(nameOfCategory);
    }

    private boolean isValid(String nameOfCategory) {
        return !isNull(nameOfCategory) && !categoryRepository.findOneByName(nameOfCategory).isPresent();
    }
}
