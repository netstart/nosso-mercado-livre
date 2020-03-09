package com.github.nossomercadolivre;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

import static java.util.Objects.isNull;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID_CATEGORY")
    private Long id;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @JoinColumn(name = "ID_CATEGORY_FATHER", referencedColumnName = "ID_CATEGORY")
    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Category categoryMother;

    /**
     * Just to framework
     */
    private Category() {
    }

    public Category(@NotNull @NotEmpty @Size(min = 3, max = 100) String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategoryMother() {
        return categoryMother;
    }

    public void setCategoryMother(Category categoryMother) {
        this.categoryMother = categoryMother;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id.equals(category.id) &&
                name.equals(category.name) &&
                categoryMother.equals(category.categoryMother);
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

    public Long getIdCategoryMother() {
        if (hasCategoryMother()) {
            getCategoryMother().getId();
        }

        return 0L;
    }

    public Boolean hasCategoryMother() {
        return isNull(getCategoryMother());
    }
}
