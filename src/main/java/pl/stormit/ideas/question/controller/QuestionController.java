package pl.stormit.ideas.question.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.stormit.ideas.question.domain.model.Question;
import pl.stormit.ideas.question.service.QuestionService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/questions")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    List<Question> getQuestions(){
        return questionService.getQuestions();
    }

    @GetMapping("{id}")
    Question getQuestion(@PathVariable UUID id){
        return questionService.getQuestion(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    Question createQuestion(@RequestBody Question question){
        return questionService.createQuestion(question);
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @PutMapping("{id}")
    Question updateQuestion(@PathVariable UUID id, @RequestBody Question question){
        return questionService.updateQuestion(id, question);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void deleteQuestion(@PathVariable UUID id){
        questionService.deleteQuestion(id);
    }

}
