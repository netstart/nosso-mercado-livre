package com.github.nossomercadolivre.exception;

public class CategoryAlreadyUsedException extends RuntimeException {

    public CategoryAlreadyUsedException() {
        super("Category name already used!");
    }

}
