package fr.formation.training.forum.controllers;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.training.forum.dtos.*;
import fr.formation.training.forum.services.QuestionService;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionService service;

    public QuestionController(QuestionService service) {
	this.service = service;
    }

    @PostMapping
    public IdentifierDto add(@RequestBody @Valid QuestionAddDto dto) {
	return service.add(dto);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable("id") Long id,
	    @RequestBody @Valid QuestionUpdateDto dto) {
	service.update(id, dto);
    }

    /**
     * Returns the aggregate view of the question with given id and all its
     * answers.
     *
     * @param id the id of the question to return a view of
     * @return the the aggregate view
     */
    @GetMapping("/{id}")
    public DiscussionViewDto getDiscussion(@PathVariable("id") Long id) {
	return service.getDiscussion(id);
    }
}
