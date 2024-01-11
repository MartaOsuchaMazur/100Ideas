package pl.stormit.ideas.question.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.stormit.ideas.category.domain.model.Category;

import java.util.*;

@ToString
@Getter
@Setter
@Entity
@Table(name="questions")
public class Question {
    @Id
    private UUID id;
    private String name;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "question")
    private Set<Answer> answers;

    public Question() {
        this.id = UUID.randomUUID();
    }

    public Question(String name) {
        this();
        this.name = name;

    }

    public Question addAnswer(Answer answer){
        if(answers == null){
            answers = new LinkedHashSet<>();
        }

        answer.setQuestion(this);
        answers.add(answer);

        return this;
    }

    public Set<Answer> getAnswers() {
        return Collections.unmodifiableSet(answers);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Question.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .toString();
    }
}
