package fr.formation.training.forum.entities;

import javax.persistence.*;

/**
 * A technology to classify questions. The natural key of the entity is the
 * name.
 */
@Entity
@Table(name = "technologies")
public class Technology extends AbstractEntity {

    @Column(name = "technology_name")
    private String name;

    @Column(name = "technology_rating")
    private double rating;

    public String getName() {
	return name;
    }

    public double getRating() {
	return rating;
    }
}
