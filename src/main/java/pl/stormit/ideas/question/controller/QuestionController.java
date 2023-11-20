package pl.stormit.ideas.question.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.stormit.ideas.question.domain.model.Question;
import pl.stormit.ideas.question.service.QuestionService;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    List<Question> getQuestions(){
        return questionService.getQuestions();
    }

    @GetMapping("/test")
    String test(@RequestParam String value){
        return questionService.test(value);
    }

}
