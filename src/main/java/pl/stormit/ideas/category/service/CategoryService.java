package pl.stormit.ideas.category.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.stormit.ideas.category.domain.model.Category;
import pl.stormit.ideas.category.domain.repository.CategoryRepository;
import pl.stormit.ideas.category.dto.CategoryWithStatisticsDto;

import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public Page<Category> getCategories(Pageable pageable) {
        return getCategories(null, pageable);
    }

    @Transactional(readOnly = true)
    public Page<Category> getCategories(String search, Pageable pageable) {
        if (search == null) {
            return categoryRepository.findAll(pageable);
        } else {
            return categoryRepository.findByNameContainingIgnoreCase(search, pageable);
        }
    }

    @Transactional(readOnly = true)
    public Category getCategory(UUID id) {
        return categoryRepository.getById(id);
    }

    @Transactional
    public Category createCategory(Category categoryRequest) {
        Category category = new Category();

        category.setName(categoryRequest.getName());

        return categoryRepository.save(category);
    }

    @Transactional
    public Category updateCategory(UUID id, Category categoryRequest) {
        Category category = categoryRepository.getById(id);
        category.setName(categoryRequest.getName());

        return categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<CategoryWithStatisticsDto> findAllWithStatistics() {
        return categoryRepository.findAllWithStatistics();
    }
}
