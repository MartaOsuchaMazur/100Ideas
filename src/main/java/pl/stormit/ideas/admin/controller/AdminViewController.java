package pl.stormit.ideas.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.stormit.ideas.question.service.QuestionService;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminViewController {

    private final QuestionService questionService;

    @GetMapping
    public String indexView(Model model){
        model.addAttribute("statistics", questionService.statistics());
        return "admin/index";
    }
}
