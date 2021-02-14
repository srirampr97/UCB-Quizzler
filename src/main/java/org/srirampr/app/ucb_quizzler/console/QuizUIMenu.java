package org.srirampr.app.ucb_quizzler.console;

import org.srirampr.app.ucb_quizzler.model.Question;
import org.srirampr.app.ucb_quizzler.model.Quiz;
import org.srirampr.app.ucb_quizzler.console.util.InputReader;

/**
 * This class handles the menu options from Quiz UI
 */
public class QuizUIMenu {

    // Function to create a new quiz based on the spec
    public Quiz handleCreateQuiz() {
        String title = askQuizTitle();
        Quiz quiz = new Quiz(title);
        boolean shouldExit = false;

        do {
            showMenu();
            char option = InputReader.readOption();
            switch (option) {
                case '1':
                    Question question = QuestionUIMenu.handleCreateQuestion();
                    quiz.addQuestion(question);
                    break;
                case '0':
                    shouldExit = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (!shouldExit);

        return quiz;
    }

    // Function to show the quiz menu and its options.
    private void showMenu() {
        System.out.println("Select an option:");
        System.out.println("1. Add a new question");
        System.out.println("0. Finish");
    }

    // Function to read the quiz title entered by the user.
    private String askQuizTitle() {
        System.out.println("Type the quiz title");
        return InputReader.readLine();
    }
}
