package com.github.nossomercadolivre;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

public class Characteristic {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotNull
    private TypeCharacteristic typeCharacteristic;

    @NotBlank
    @Column(nullable = false)
    private String value;

    @Deprecated
    private Characteristic() {
    }

    public Characteristic(@NotNull TypeCharacteristic typeCharacteristic, @NotBlank String value) {
        this.typeCharacteristic = typeCharacteristic;
        this.value = value;
    }

    public TypeCharacteristic getTypeCharacteristic() {
        return typeCharacteristic;
    }

    public String getValue() {
        return value;
    }
}
