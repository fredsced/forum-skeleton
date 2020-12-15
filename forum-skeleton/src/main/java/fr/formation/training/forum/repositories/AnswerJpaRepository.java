package fr.formation.training.forum.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.*;

import fr.formation.training.forum.dtos.AnswerViewDto;
import fr.formation.training.forum.entities.Answer;

public interface AnswerJpaRepository extends JpaRepository<Answer, Long> {

    @Query("select new fr.formation.training.forum.dtos.AnswerViewDto"
	    + "(a.text, a.author, a.answerDate) "
	    + "from Answer a where a.question.id = :id order by a.answerDate desc")
    List<AnswerViewDto> findProjectedByQuestionId(Long id);
}
