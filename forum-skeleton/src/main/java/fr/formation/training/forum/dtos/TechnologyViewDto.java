package fr.formation.training.forum.dtos;

public class TechnologyViewDto {

    private final Long id;

    private final String name;

    private final double rating;

    public TechnologyViewDto(Long id, String name, double rating) {
	this.id = id;
	this.name = name;
	this.rating = rating;
    }

    public Long getId() {
	return id;
    }

    public String getName() {
	return name;
    }

    public double getRating() {
	return rating;
    }
}
