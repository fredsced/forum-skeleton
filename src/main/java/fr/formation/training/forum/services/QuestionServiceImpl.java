package fr.formation.training.forum.services;

import fr.formation.training.forum.NotFoundException;
import fr.formation.training.forum.dtos.*;
import fr.formation.training.forum.entities.Question;
import fr.formation.training.forum.entities.Technology;
import fr.formation.training.forum.repositories.QuestionJpaRepository;
import fr.formation.training.forum.repositories.TechnologyJpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class QuestionServiceImpl extends AbstractService
        implements QuestionService {

    private final QuestionJpaRepository questions;

    private final TechnologyJpaRepository technologies;

    public QuestionServiceImpl(QuestionJpaRepository questions,
                               TechnologyJpaRepository technologies) {
        this.questions = questions;
        this.technologies = technologies;
    }

    @Override
    public IdentifierDto add(QuestionAddDto dto) {
        Question question = getMapper().map(dto, Question.class);
        question.setQuestionDate(LocalDateTime.now());
        setTechnology(question, dto.getTechnologyId());
        questions.save(question);
        return new IdentifierDto(question.getId());
    }

    @Override
    public void update(Long id, QuestionUpdateDto dto) {
        Question question = questions.findById(id).orElseThrow(NotFoundException::new);
        getMapper().map(dto, question);
        setTechnology(question, dto.getTechnologyId());
        questions.save(question);
    }

    @Override
    public DiscussionViewDto getDiscussion(Long id) {
        QuestionViewDto questionView = questions.findProjectedById(id);
        return new DiscussionViewDto(questionView);
    }

    private void setTechnology(Question question, Long technologyId) {
        Technology technology = technologies.getOne(technologyId);
        question.setTechnology(technology);
    }
}
