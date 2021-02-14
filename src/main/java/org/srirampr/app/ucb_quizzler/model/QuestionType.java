package org.srirampr.app.ucb_quizzler.model;

import org.srirampr.app.ucb_quizzler.model.configuration.QuestionConfiguration;
import org.srirampr.app.ucb_quizzler.model.configuration.TextConfiguration;
import org.srirampr.app.ucb_quizzler.model.validator.ValidatorType;
import org.srirampr.app.ucb_quizzler.model.configuration.DateConfiguration;
import org.srirampr.app.ucb_quizzler.model.configuration.PickOneConfiguration;

/**
 * QuestionType class contains question and validator configurations
 */
public enum QuestionType {
    TEXT(1, "Text", new TextConfiguration()),
    DATE(2, "Date", new DateConfiguration()),
    PICK_ONE(3, "Pick One", new PickOneConfiguration());

    private final int code;
    private final String displayName;
    private final QuestionConfiguration configuration;

    QuestionType(int code, String displayName, QuestionConfiguration configuration) {
        this.code = code;
        this.displayName = displayName;
        this.configuration = configuration;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return displayName;
    }

    public boolean hasAdditionalData() {
        return configuration.hasAdditionalData();
    }

    public ValidatorType[] getValidations() {
        return configuration.getSupportedValidations();
    }

    public QuestionConfiguration getConfiguration() {
        return configuration;
    }

    public static QuestionType getByCode(int option) {
        for (QuestionType type : QuestionType.values()) {
            if (type.getCode() == option) {
                return type;
            }
        }

        return null;
    }
}
