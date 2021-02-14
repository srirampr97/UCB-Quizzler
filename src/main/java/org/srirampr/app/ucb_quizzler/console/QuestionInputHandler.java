package org.srirampr.app.ucb_quizzler.console;

import java.util.HashSet;
import java.util.Set;

import org.srirampr.app.ucb_quizzler.model.Question;
import org.srirampr.app.ucb_quizzler.console.util.InputReader;

/**
 * Class to collect answers for a given question
 */
public class QuestionInputHandler {

    // Function to show the current question and request its answer
    public Set<String> askQuestionValue(Question question) {
        System.out.println("Question: " + question.getTitle());
        return getAnswer(question);
    }

    // Function to get answers for a question
    private Set<String> getAnswer(Question question) {
        Set<String> answers = new HashSet<>();
        if (question.getType().getConfiguration().hasAdditionalData()) {
            answers.add(collectAnswerFromOptions(question));
        } else {
            System.out.println(question.getType().getName() + " value:");
            String value = InputReader.readLine();
            answers.add(value);
        }

        return answers;
    }

    // Function to collect the answer for the given options
    private String collectAnswerFromOptions(Question question) {
        String answer = null;

        while (true) {
            showOptions(question);
            char option = InputReader.readOption();
            if (option == '0') {
                break;
            }
        }

        return answer;
    }

    // Function to show options to either add a new question or to return
    private void showOptions(Question question) {
        System.out.println("Select an option: ");
        for (int index = 0; index < question.getAdditionalData().size(); index++) {
            System.out.printf("%d. %s" + System.lineSeparator(), index + 1, question.getAdditionalData().get(index));
        }
        System.out.println("0. To Finish");
    }
}
