package org.srirampr.app.ucb_quizzler.console;

import org.srirampr.app.ucb_quizzler.model.Question;
import org.srirampr.app.ucb_quizzler.model.QuestionType;
import org.srirampr.app.ucb_quizzler.model.validator.ValidatorType;
import org.srirampr.app.ucb_quizzler.console.util.InputReader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ InputReader.class })
public class QuestionUIMenuIT {

    @Test
    public void testHandleCreateQuestion() {
        PowerMockito.mockStatic(InputReader.class);
        PowerMockito.when(InputReader.readLine()).thenReturn("Test");
        PowerMockito.when(InputReader.readOption()).thenReturn('1', '0');

        Question question = QuestionUIMenu.handleCreateQuestion();

        Assert.assertEquals("Test", question.getTitle());
        Assert.assertEquals(QuestionType.TEXT, question.getType());
        Assert.assertTrue(question.getValidations().isEmpty());
    }

    @Test
    public void testHandleCreateQuestionInvalidQuestionType() {
        PowerMockito.mockStatic(InputReader.class);
        PowerMockito.when(InputReader.readLine()).thenReturn("Test");
        PowerMockito.when(InputReader.readOption()).thenReturn('9', '0');

        Question question = QuestionUIMenu.handleCreateQuestion();

        Assert.assertNull(question);
    }

    @Test
    public void testHandleCreateQuestionWithValidators() {
        PowerMockito.mockStatic(InputReader.class);
        PowerMockito.when(InputReader.readLine()).thenReturn("Test");
        PowerMockito.when(InputReader.readOption()).thenReturn('1', '1', '0');

        Question question = QuestionUIMenu.handleCreateQuestion();

        Assert.assertEquals("Test", question.getTitle());
        Assert.assertEquals(QuestionType.TEXT, question.getType());
        Assert.assertFalse(question.getValidations().isEmpty());
        Assert.assertEquals(ValidatorType.REQUIRED, question.getValidations().get(0));
    }
}
