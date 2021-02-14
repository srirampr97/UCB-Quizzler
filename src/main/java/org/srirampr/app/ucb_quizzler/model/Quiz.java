package org.srirampr.app.ucb_quizzler.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Quiz class to hold the quiz title and the list of questions
 */
public class Quiz {
    private final String title;
    private final List<Question> questions;

    // Initialize a new quiz for the given title and create an empty arraylist of questions.
    public Quiz(String title) {
        this.title = title;
        this.questions = new ArrayList<>();
    }

    // Returns the title of the quiz
    public String getTitle() {
        return title;
    }

    // Adds a new question to the questions list
    public void addQuestion(Question question) {
        questions.add(question);
    }

    // Returns an array of questions
    public List<Question> getQuestions() {
        return questions;
    }
}
