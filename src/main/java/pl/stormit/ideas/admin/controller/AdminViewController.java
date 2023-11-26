package pl.stormit.ideas.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.stormit.ideas.category.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class AdminViewController {

   // private final CategoryService categoryService;

 //   public AdminViewController(CategoryService categoryService) {
  //      this.categoryService = categoryService;
 //   }

    @GetMapping
    public String indexView(){
        return "admin/index";
    }
}
