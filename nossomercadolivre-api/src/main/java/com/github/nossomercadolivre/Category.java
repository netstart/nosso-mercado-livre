package com.github.nossomercadolivre;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Optional;

import static java.util.Optional.ofNullable;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @JoinColumn(name = "ID_CATEGORY_MOTHER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Category categoryMother;

    /**
     * Just to framework
     */
    protected Category() {
    }

    public Category(final Long id, final String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<Category> getCategoryMother() {
        return ofNullable(categoryMother);
    }

    public void setCategoryMother(Category categoryMother) {
        this.categoryMother = categoryMother;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return name.equals(category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, categoryMother);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categoryMother=" + categoryMother +
                '}';
    }

}
