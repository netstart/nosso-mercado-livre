package com.github.nossomercadolivre;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.nossomercadolivre.validation.UniqueNameCategory;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import static java.util.Objects.isNull;

@JsonInclude(NON_NULL)
public class CategoryDTO {
    public Long id;

    @NotNull
    @NotEmpty
    @Size(max = 100)
    @UniqueNameCategory
    public String name;

    public CategoryDTO categoryMother;

    /**
     * For frameworks, don't use it
     */
    @Deprecated
    private CategoryDTO() {
    }

    public CategoryDTO(final Category category) {
        this.id = category.getId();
        this.name = category.getName();
        if (hasObjectCategoryMother()) {
            this.categoryMother = new CategoryDTO(category.getCategoryMother());
        }
    }

    public static CategoryDTO toDTO(final Category category) {
        return new CategoryDTO(category);
    }

    public Category toModel() {
        return new Category(this.name);
    }

    public Long idCategoryMother() {
        if (hasObjectCategoryMother() && hasIdOfCategoryMother()) {
            return categoryMother.id;
        }

        return 0L;
    }

    private boolean hasObjectCategoryMother() {
        return !isNull(this.categoryMother);
    }

    private boolean hasIdOfCategoryMother() {
        return !isNull(this.categoryMother.id);
    }

}
