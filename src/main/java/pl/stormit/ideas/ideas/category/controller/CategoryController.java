package pl.stormit.ideas.ideas.category.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.stormit.ideas.ideas.category.domain.model.Category;
import pl.stormit.ideas.ideas.category.service.CategoryService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/questions/{question-id}/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    List<Category> getCategories(@PathVariable("question-id") UUID questionId){
        return categoryService.getCategories(questionId);
    }

    @GetMapping("{category-id}")
    Category getCategory(@PathVariable("question-id") UUID questionId, @PathVariable("category-id") UUID categoryId){
        return categoryService.getCategory(categoryId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Category createCategory(@PathVariable("question-id") UUID questionId, @RequestBody Category category){
        return categoryService.createCategory(questionId, category);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("{answer-id}")
    Category updateCategory(@PathVariable("question-id") UUID questionId, @PathVariable("category-id") UUID categoryId,
                        @RequestBody Category category){
        return categoryService.updateCategory(categoryId, category);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{answer-id}")
    void deleteCategory(@PathVariable("category-id") UUID categoryId){
        categoryService.deleteCategory(categoryId);
    }
}
