package pl.stormit.ideas.ideas.category.service;

import org.springframework.stereotype.Service;
import pl.stormit.ideas.ideas.category.domain.model.Category;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryService {

    public List<Category> getCategories(UUID questionId) {
        return Arrays.asList(new Category("Category 1"), new Category("Category 2"));
    }

    public Category getCategory(UUID id) {
        return new Category("Category " + id);
    }

    public Category createCategory(UUID questionId, Category category) {
        return null;
    }

    public Category updateCategory(UUID categoryId, Category category) {
        return null;
    }

    public void deleteCategory(UUID categoryId) {
    }
}
