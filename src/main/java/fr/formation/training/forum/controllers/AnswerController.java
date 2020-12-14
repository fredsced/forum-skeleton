package fr.formation.training.forum.controllers;


import fr.formation.training.forum.dtos.AnswerAddDto;
import fr.formation.training.forum.dtos.AnswerUpdateDto;
import fr.formation.training.forum.dtos.IdentifierDto;
import fr.formation.training.forum.services.AnswerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerService service;

    public AnswerController(AnswerService answerService) {
        this.service = answerService;
    }

    @PostMapping
    public IdentifierDto add(@RequestBody @Valid AnswerAddDto dto) {
        return service.add(dto);
    }
    @PatchMapping("/{id}")

    public void update(@PathVariable("id") Long id, @RequestBody @Valid AnswerUpdateDto dto ){
        service.update(id, dto);
    }
}
