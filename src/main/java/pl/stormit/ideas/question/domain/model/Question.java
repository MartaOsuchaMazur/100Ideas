package pl.stormit.ideas.question.domain.model;

import java.util.StringJoiner;

public class Question {

    private String name;

    public Question() {
    }

    public Question(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Question.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .toString();
    }
}
