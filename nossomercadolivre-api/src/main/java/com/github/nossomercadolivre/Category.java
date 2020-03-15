package com.github.nossomercadolivre;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table
public class Category {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_CATEGORY")
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @JoinColumn(name = "ID_CATEGORY_FATHER", referencedColumnName = "ID_CATEGORY")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Category categoryMother;

    /**
     * Just to framework
     */
    protected Category() {
    }

    public Category(@NotNull @NotEmpty @Size(max = 100) final String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategoryMother() {
        return categoryMother;
    }

    public void setCategoryMother(final Category categoryMother) {
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
