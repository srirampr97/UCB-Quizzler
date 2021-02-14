package org.srirampr.app.ucb_quizzler;

import org.srirampr.app.ucb_quizzler.console.QuizUIHandler;
import org.srirampr.app.ucb_quizzler.model.Quiz;
import org.srirampr.app.ucb_quizzler.model.QuizAnswers;
import org.srirampr.app.ucb_quizzler.console.util.InputReader;

public class Menu {

    private Quiz quiz;
    private QuizAnswers quizAnswers;

    public Menu() {
        this.quiz = null;
        this.quizAnswers = null;
    }

    public boolean process() {
        showMainMenu();
        char option = InputReader.readOption();
        boolean shouldExit = false;
        switch (option) {
            case '1':
                quiz = QuizUIHandler.createQuiz();
                break;
            case '2':
                fillQuiz();
                break;
            case '3':
                showQuiz();
                break;
            case '4':
                shouldExit = true;
                break;
            default:
                System.out.println("Invalid option");
                break;
        }

        System.out.println(System.lineSeparator());
        return shouldExit;
    }

    private void showQuiz() {
        if (quiz == null || quizAnswers == null) {
            System.out.println("Sorry, no filled quiz available, please create and fill a quiz");
            return;
        }

        QuizUIHandler.showQuiz(quizAnswers);
    }

    private void fillQuiz() {
        if (quiz == null) {
            System.out.println("Sorry, no quiz available, please create a new quiz");
            return;
        }

        quizAnswers = QuizUIHandler.fillQuiz(quiz);
    }

    private void showMainMenu() {
        System.out.println("UCB-Quizzler");
        System.out.println("<======================================>");
        System.out.println("Choose any of the below options");
        System.out.println("1. Create quiz");
        System.out.println("2. Fill quiz");
        System.out.println("3. Show quiz");
        System.out.println("4. Exit");
        System.out.println("<======================================>");
    }
}
