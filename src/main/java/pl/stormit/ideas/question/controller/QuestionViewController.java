package pl.stormit.ideas.question.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.stormit.ideas.IdeasConfiguration;
import pl.stormit.ideas.category.service.CategoryService;
import pl.stormit.ideas.common.controller.IdeasCommonViewController;
import pl.stormit.ideas.question.domain.model.Question;
import pl.stormit.ideas.question.service.AnswerService;
import pl.stormit.ideas.question.service.QuestionService;

import java.util.UUID;

import static pl.stormit.ideas.common.controller.ControllerUtils.paging;


@Controller
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionViewController extends IdeasCommonViewController {

    private final QuestionService questionService;
    private final AnswerService answerService;
    private final CategoryService categoryService;
    private final IdeasConfiguration ideasConfiguration;



    @GetMapping
    public String indexView(Model model){
        model.addAttribute("questions", questionService.getQuestions());
        addGlobalAttributes(model);

        return "question/index";
    }



    @GetMapping("{id}")
    public String singleView(Model model, @PathVariable UUID id){
        model.addAttribute("question", questionService.getQuestion(id));
        model.addAttribute("answers", answerService.getAnswers(id));
        addGlobalAttributes(model);

        return "question/single";
    }

    @GetMapping("add")
    public String addView(Model model){
        model.addAttribute("question", new Question());

        return "question/add";
    }

    @PostMapping
    public String add(Question question) {
        questionService.createQuestion(question);

        return "redirect:/questions";
    }

    @GetMapping("hot")
    public String hotView(
            @RequestParam(name = "page", defaultValue = "1") int page,
            Model model
    ){
        PageRequest pageRequest = PageRequest.of(page -1, ideasConfiguration.getPagingPageSize());

        Page<Question> questionsPage = questionService.findHot(pageRequest);

        model.addAttribute("questionsPage", questionsPage);
        paging(model, questionsPage);
        addGlobalAttributes(model);

        return "question/index";
    }

    @GetMapping("unanswered")
    public String unansweredView(
            @RequestParam(name = "page", defaultValue = "1") int page,
            Model model
    ){
        PageRequest pageRequest = PageRequest.of(page -1, ideasConfiguration.getPagingPageSize());

        Page<Question> questionsPage = questionService.findUnanswered(pageRequest);

        model.addAttribute("questionsPage", questionsPage);
        paging(model, questionsPage);
        addGlobalAttributes(model);

        return "question/index";
    }
}
