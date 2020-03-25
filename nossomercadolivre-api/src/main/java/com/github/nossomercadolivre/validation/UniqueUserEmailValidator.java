package com.github.nossomercadolivre.validation;

import com.github.nossomercadolivre.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.util.Objects.isNull;

public class UniqueUserEmailValidator implements ConstraintValidator<UniqueUserEmail, String> {

    private final UserRepository userRepository;

    public UniqueUserEmailValidator(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean isValid(String email, ConstraintValidatorContext context) {
        return isValid(email);
    }

    private boolean isValid(String email) {
        return !isNull(email) && !userRepository.findOneByEmail(email).isPresent();
    }
}
