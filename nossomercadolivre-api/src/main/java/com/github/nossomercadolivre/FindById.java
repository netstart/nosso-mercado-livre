package com.github.nossomercadolivre;

import java.util.Optional;

@FunctionalInterface
public interface FindById<T, ID> {
    Optional<T> findById(ID id);
}
