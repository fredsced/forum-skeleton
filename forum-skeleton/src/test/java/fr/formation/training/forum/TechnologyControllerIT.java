package fr.formation.training.forum;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;

public class TechnologyControllerIT extends IntegrationTest {

    @Value("${mockserver.paths.technologies}")
    private String path; // /api/technologies

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
		.andExpect(jsonPath("$.[0].rating", is(16.47)))
		.andExpect(jsonPath("$.[-1].rating", is(1.53)));
    }
    // @Autowired
    // private TechnologyController controller;
    //
    // @Test
    // void testController() {
    // List<TechnologyViewDto> result = controller.getAll();
    // assertEquals(9, result.size());
    // }
}
