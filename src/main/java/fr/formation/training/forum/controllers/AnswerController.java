package fr.formation.training.forum.controllers;


import fr.formation.training.forum.dtos.AnswerAddDto;
import fr.formation.training.forum.dtos.IdentifierDto;
import fr.formation.training.forum.services.AnswerService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

    @PostMapping
    public IdentifierDto add(@RequestBody @Valid AnswerAddDto dto) {
        return answerService.add(dto);
    }
}
