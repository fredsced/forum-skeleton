package fr.formation.training.forum.controllers;

import fr.formation.training.forum.IntegrationTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class QuestionControllerTest extends IntegrationTest {

    @Value("${mockserver.paths.questions}")
    private String path;


    @ParameterizedTest
    @CsvFileSource(resources = "/questions-success.csv", delimiterString = "|$|", numLinesToSkip = 1)
    void shouldAddQuestion(String question) throws Exception {
        api.perform(post(path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(question))
                .andExpect(status().isOk());
    }

}