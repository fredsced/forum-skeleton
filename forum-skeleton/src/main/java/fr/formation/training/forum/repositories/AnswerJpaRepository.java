package fr.formation.training.forum.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.training.forum.entities.Answer;

public interface AnswerJpaRepository extends JpaRepository<Answer, Long> {
    //
}
