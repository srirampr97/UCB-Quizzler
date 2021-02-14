package org.srirampr.app.ucb_quizzler.model.configuration;

import org.srirampr.app.ucb_quizzler.model.validator.ValidatorType;

public abstract class QuestionConfiguration {
    private final boolean hasAdditionalData;
    private final ValidatorType[] supportedValidations;

    QuestionConfiguration(boolean hasAdditionalData, ValidatorType... supportedValidations) {
        this.hasAdditionalData = hasAdditionalData;
        this.supportedValidations = supportedValidations;
    }

    public boolean hasAdditionalData() {
        return hasAdditionalData;
    }

    public String convertValue(String value) {
        return value;
    }

    public ValidatorType[] getSupportedValidations() {
        return supportedValidations;
    }
}
