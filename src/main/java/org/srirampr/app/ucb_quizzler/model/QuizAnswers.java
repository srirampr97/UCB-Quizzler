package org.srirampr.app.ucb_quizzler.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Class which contains a list of question-answers for a quiz
 */
public class QuizAnswers {
    private final Quiz quiz;
    private final UUID id;
    private final List<Answer> answers;

    // Initialize quiz answer properties.
    public QuizAnswers(Quiz quiz) {
        this.quiz = quiz;
        this.id = UUID.randomUUID();
        this.answers = new ArrayList<>();
    }

    // Function to add an answer to the answers array
    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    // Returns the unique id
    public UUID getId() {
        return id;
    }

    // Returns the current quiz
    public Quiz getQuiz() {
        return quiz;
    }

    // Returns the araylist of answers
    public List<Answer> getAnswers() {
        return answers;
    }
}
