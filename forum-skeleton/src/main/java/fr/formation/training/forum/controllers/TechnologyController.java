package fr.formation.training.forum.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import fr.formation.training.forum.dtos.TechnologyViewDto;
import fr.formation.training.forum.services.TechnologyService;

@RestController
@RequestMapping("/technologies")
public class TechnologyController {

    private final TechnologyService service;

    public TechnologyController(TechnologyService service) {
	this.service = service;
    }

    @GetMapping("/{id}")
    public TechnologyViewDto getOne(@PathVariable("id") Long id) {
	return service.getOne(id);
    }

    @GetMapping
    public List<TechnologyViewDto> getAll() {
	return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void deleteOne(@PathVariable("id") Long id) {
	// TODO
    }

    @DeleteMapping
    public void deleteAll() {
	// TODO
    }
    // For illustration:

    @DeleteMapping("/bad")
    public void deleteBad() {
	service.deleteBad();
    }
}
