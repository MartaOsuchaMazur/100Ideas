package pl.stormit.ideas.question.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.StringJoiner;
import java.util.UUID;

@Setter
@Getter
@ToString
@Entity
@Table(name="answers")
public class Answer {
    @Id
    private UUID id;
    private String name;

    @ManyToOne
    private Question question;

    public Answer() {
        this.id = UUID.randomUUID();
    }

    public Answer(String name) {
        this();
        this.name = name;

    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Answer.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .toString();
    }
}
