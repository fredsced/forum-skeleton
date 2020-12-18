package fr.formation.training.forum;


import fr.formation.training.forum.dtos.QuestionAddDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class QuestionAddDtoTest {
    @Test
    void should_create_question_with_no_params() {
        QuestionAddDto actual = new QuestionAddDto();
        assertNotNull(actual, "Question failed");
    }
}
