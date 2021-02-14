package org.srirampr.app.ucb_quizzler.model.configuration;

import org.srirampr.app.ucb_quizzler.model.validator.ValidatorType;

public class TextConfiguration extends QuestionConfiguration {
    public TextConfiguration() {
        super(false, ValidatorType.REQUIRED, ValidatorType.MIN_LENGTH);
    }
}
