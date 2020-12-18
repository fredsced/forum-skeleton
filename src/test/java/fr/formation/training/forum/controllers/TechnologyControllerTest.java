package fr.formation.training.forum.controllers;

import fr.formation.training.forum.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

import static org.hamcrest.CoreMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class TechnologyControllerTest extends IntegrationTest {
    @Value("${mockserver.paths.technologies}")
    private String path;

    @Test
    void shouldGetAllWithStatusOk() throws Exception {
        api.perform(get(path)).andExpect(status().isOk());
    }

    @Test
    void shouldGetOneWithStatusOk() throws Exception {
        api.perform(get(path + "/1")).andExpect(status().isOk());
    }

    @Test
    void shouldNotGetOneWithStatusNotFound() throws Exception {
        api.perform(get(path + "/0")).andExpect(status().isNotFound());
    }

    @Test
    void shouldGetAllOrderedByRatingDesc() throws Exception {
        api.perform(get(path)).andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].rating", equalTo(16.48)))
                .andExpect(jsonPath("$.[-1].rating", equalTo(1.53)));
    }
}