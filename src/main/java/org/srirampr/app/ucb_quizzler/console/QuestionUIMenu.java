package org.srirampr.app.ucb_quizzler.console;

import java.util.ArrayList;
import java.util.List;

import org.srirampr.app.ucb_quizzler.model.Question;
import org.srirampr.app.ucb_quizzler.model.QuestionType;
import org.srirampr.app.ucb_quizzler.model.validator.ValidatorType;
import org.srirampr.app.ucb_quizzler.console.util.InputReader;
import org.srirampr.app.ucb_quizzler.model.Question.QuestionBuilder;

/**
 * Class that handles all Question related operations
 */
public class QuestionUIMenu {

    // Function to build a question with the menu options
    public static Question handleCreateQuestion() {
        QuestionUIMenu menu = new QuestionUIMenu();
        String title = menu.askQuestionTitle();
        QuestionType questionType = menu.askQuestionType();
        if (questionType == null) {
            return null;
        }

        QuestionBuilder builder = new QuestionBuilder(title, questionType);
        if (questionType.hasAdditionalData()) {
            builder.setAdditionalData(menu.askAdditionalData());
        }

        while (true) {
            ValidatorType validator = menu.askValidation(questionType, builder.getValidations());
            if (validator == null || builder.addValidation(validator)) {
                break;
            }
        }

        return builder.build();
    }

    // Function to set the validation type for the question
    private ValidatorType askValidation(QuestionType questionType, List<ValidatorType> validations) {
        System.out.println("Select a validation to add");
        for (ValidatorType validation : questionType.getValidations()) {
            if (validations.contains(validation)) {
                continue;
            }

            System.out.printf("%d. %s" + System.lineSeparator(), validation.getCode(), validation.getName());
        }
        System.out.println("0. To exit");
        char option = InputReader.readOption();
        if (option == '0') {
            return null;
        }

        return ValidatorType.getByCode(Character.getNumericValue(option));
    }

    // Set option for the question
    private List<String> askAdditionalData() {
        List<String> additionalData = new ArrayList<>();
        boolean shouldExit = false;

        do {
            System.out.println("Select an action:");
            System.out.println("1. Add question option");
            System.out.println("0. Exit");
            char option = InputReader.readOption();

            switch (option) {
                case '1':
                    System.out.println("Option value");
                    additionalData.add(InputReader.readLine());
                    break;
                case '0':
                    shouldExit = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }

        } while (!shouldExit);

        return additionalData;
    }

    // Function to register the question type.
    private QuestionType askQuestionType() {
        System.out.println("Select a question to add");
        for (QuestionType type : QuestionType.values()) {
            System.out.printf("%d. %s" + System.lineSeparator(), type.getCode(), type.getName());
        }
        char option = InputReader.readOption();

        return QuestionType.getByCode(Character.getNumericValue(option));
    }

    // Function to receive the question title.
    private String askQuestionTitle() {
        System.out.println("Enter the title");
        return InputReader.readLine();
    }
}
