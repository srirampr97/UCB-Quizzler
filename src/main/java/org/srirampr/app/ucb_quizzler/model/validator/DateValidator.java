package org.srirampr.app.ucb_quizzler.model.validator;

import java.text.ParseException;
import java.util.List;

import org.srirampr.app.ucb_quizzler.model.configuration.DateConfiguration;

public class DateValidator implements Validator {

    private static final String DATE_ERROR_MESSAGE = "Provided date format is invalid, please format it to dd/MM/yyyy";

    @Override
    public void validate(String value, String conditionValue, List<String> errors) {
        try {
            DateConfiguration.FORMATTER.parse(value);
        } catch (ParseException exception) {
            errors.add(DATE_ERROR_MESSAGE);
        }
    }
}
