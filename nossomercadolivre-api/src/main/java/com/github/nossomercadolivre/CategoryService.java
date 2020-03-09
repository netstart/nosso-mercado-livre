package com.github.nossomercadolivre;

import com.github.nossomercadolivre.exception.CategoryAlreadyUsedException;
import com.github.nossomercadolivre.exception.UsernameAlreadyUsedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.github.nossomercadolivre.CategoryDTO.toDTO;

@Service
@Transactional
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryDTO save(CategoryDTO categoryDTO) {

        categoryRepository.findOneByName(categoryDTO.getName()).ifPresent(existingCategory -> {
            throw new CategoryAlreadyUsedException();
        });

        Category category = new Category(categoryDTO.getName());

        categoryRepository.findById(categoryDTO.idCategoryMother()).ifPresent(c -> category.setCategoryMother(c));

        Category categorySaved = categoryRepository.save(category);

        return toDTO(categorySaved);
    }
}
