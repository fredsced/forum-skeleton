package fr.formation.training.forum.controllers;

import fr.formation.training.forum.dtos.DiscussionViewDto;
import fr.formation.training.forum.dtos.IdentifierDto;
import fr.formation.training.forum.dtos.QuestionAddDto;
import fr.formation.training.forum.dtos.QuestionUpdateDto;
import fr.formation.training.forum.services.QuestionService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @DeleteMapping("/{id}")
    public void removeDiscussion(@PathVariable("id") Long id) {
        service.remove(id);
    }
}
