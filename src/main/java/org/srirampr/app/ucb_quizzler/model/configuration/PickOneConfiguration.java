package org.srirampr.app.ucb_quizzler.model.configuration;

import org.srirampr.app.ucb_quizzler.model.validator.ValidatorType;

public class PickOneConfiguration extends QuestionConfiguration {

    public PickOneConfiguration() {
        super(true, ValidatorType.REQUIRED);
    }

}
