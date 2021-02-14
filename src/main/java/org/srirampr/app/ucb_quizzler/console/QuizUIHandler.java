package org.srirampr.app.ucb_quizzler.console;

import java.util.Set;

import org.srirampr.app.ucb_quizzler.model.Answer;
import org.srirampr.app.ucb_quizzler.model.Question;
import org.srirampr.app.ucb_quizzler.model.Quiz;
import org.srirampr.app.ucb_quizzler.model.QuizAnswers;
import org.srirampr.app.ucb_quizzler.console.util.InputReader;

public class QuizUIHandler {

	public static Quiz createQuiz() {
		return new QuizUIMenu().handleCreateQuiz();
	}

	public static QuizAnswers fillQuiz(Quiz quiz) {
		QuizAnswers quizAnswers = new QuizAnswers(quiz);
		QuestionInputHandler questionHandler = new QuestionInputHandler();

		System.out.println("Quiz: " + quiz.getTitle());
		for (Question question : quiz.getQuestions()) {
			Set<String> answers = questionHandler.askQuestionValue(question);
			Answer answer = new Answer(question, answers);
			quizAnswers.addAnswer(answer);
		}

		return quizAnswers;
	}

	public static void showQuiz(QuizAnswers quizAnswers) {
		System.out.println(quizAnswers.getQuiz().getTitle());
		System.out.println("=============================================");

		for (Answer answer : quizAnswers.getAnswers()) {
			System.out.println(answer);
		}

		System.out.println("=============================================");
		System.out.println("Press ENTER to continue");
		InputReader.readLine();
	}
}
