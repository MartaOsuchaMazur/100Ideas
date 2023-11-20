package pl.stormit.ideas.question.service;

import org.springframework.stereotype.Service;
import pl.stormit.ideas.IdeasConfiguration;
import pl.stormit.ideas.question.domain.model.Question;

import java.util.Arrays;
import java.util.List;

@Service
public class QuestionService {

    private final IdeasConfiguration ideasConfiguration;

    public QuestionService(IdeasConfiguration ideasConfiguration) {
        this.ideasConfiguration = ideasConfiguration;
    }

    public List<Question> getQuestions() {
        return Arrays.asList(new Question("Question 1"), new Question("Question 2"));
    }

    public String test(String value) {
        return String.format("Hello %s %s", ideasConfiguration.getName(), value);
    }
}
