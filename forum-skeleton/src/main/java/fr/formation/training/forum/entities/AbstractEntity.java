package fr.formation.training.forum.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Long id;

    public Long getId() {
	return id;
    }
}
