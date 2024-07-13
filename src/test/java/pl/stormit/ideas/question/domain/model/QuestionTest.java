package pl.stormit.ideas.question.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    private Question question;

    @BeforeEach
    void setUp() {
        question = new Question();
    }

    @Test
    void shouldAddAnswer() {

        Answer answer = new Answer();

        question.addAnswer(answer);

        assertEquals(1, question.getAnswers().size());
        assertTrue(question.getAnswers().contains(answer));
        assertNotNull(question.getAnswers());
    }
    @Test
    void shouldAddAnswerWhenAnswersIsNull(){

        Answer answer = new Answer();

        question.addAnswer(answer);

        assertNotNull(question.getAnswers());
    }
}