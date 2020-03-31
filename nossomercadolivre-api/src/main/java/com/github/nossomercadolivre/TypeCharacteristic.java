package com.github.nossomercadolivre;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import static javax.persistence.GenerationType.IDENTITY;

public class TypeCharacteristic {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String label;

    @Deprecated
    private TypeCharacteristic() {
    }

    public TypeCharacteristic(@NotBlank String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
