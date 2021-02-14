package org.srirampr.app.ucb_quizzler.model.validator;

import java.util.List;

public class MinLengthValidator implements Validator {

    private static final String MIN_LENGTH_ERROR_MESSAGE = "The value length must be less than ";

    @Override
    public void validate(String value, String conditionValueString, List<String> errors) {
        try {
            int conditionValue = IntegerParser.parse(conditionValueString);

            if (value.length() < conditionValue) {
                errors.add(MIN_LENGTH_ERROR_MESSAGE + conditionValue);
            }
        } catch (NumberFormatException exception) {
            exception.printStackTrace();
            errors.add(IntegerParser.ERROR_MESSAGE_INVALID_NUMBER);
        }

    }
}
