package org.srirampr.app.ucb_quizzler.model.validator;

import java.util.List;

public interface Validator {
    void validate(String value, String conditionValue, List<String> errors);
}
