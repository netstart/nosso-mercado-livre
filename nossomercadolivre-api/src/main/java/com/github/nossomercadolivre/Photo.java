package com.github.nossomercadolivre;

import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @NotBlank
    @URL
    @Column(nullable = false)
    private String url;

//    @NotNull
//    @Column(nullable = false)
//    private Product product;


    @Deprecated
    protected Photo() {
    }

    public Photo(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return Objects.equals(url, photo.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, url);
    }
}
