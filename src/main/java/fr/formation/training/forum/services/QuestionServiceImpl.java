package fr.formation.training.forum.services;

import fr.formation.training.forum.NotFoundException;
import fr.formation.training.forum.dtos.*;
import fr.formation.training.forum.entities.Question;
import fr.formation.training.forum.entities.Technology;
import fr.formation.training.forum.repositories.AnswerJpaRepository;
import fr.formation.training.forum.repositories.QuestionJpaRepository;
import fr.formation.training.forum.repositories.TechnologyJpaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuestionServiceImpl extends AbstractService
        implements QuestionService {

    private final QuestionJpaRepository questions;

    private final TechnologyJpaRepository technologies;

    private final AnswerJpaRepository answers;

    public QuestionServiceImpl(QuestionJpaRepository questions,
                               TechnologyJpaRepository technologies,
                               AnswerJpaRepository answers) {
        this.questions = questions;
        this.technologies = technologies;
        this.answers = answers;
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
        QuestionViewDto questionView = questions.findProjectedById(id).orElseThrow(NotFoundException::new);
        List<AnswerViewDto> answersListViewDto = answers.findAllProjectedById(id);
        return new DiscussionViewDto(questionView, answersListViewDto);
    }

    private void setTechnology(Question question, Long technologyId) {
        Technology technology = technologies.getOne(technologyId);
        question.setTechnology(technology);
    }
}
