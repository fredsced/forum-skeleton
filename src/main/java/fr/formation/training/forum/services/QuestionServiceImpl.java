package fr.formation.training.forum.services;

import fr.formation.training.forum.NotFoundException;
import fr.formation.training.forum.dtos.*;
import fr.formation.training.forum.entities.Question;
import fr.formation.training.forum.entities.Technology;
import fr.formation.training.forum.repositories.AnswerJpaRepository;
import fr.formation.training.forum.repositories.QuestionJpaRepository;
import fr.formation.training.forum.repositories.TechnologyJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(readOnly = false)
    @Override
    public IdentifierDto add(QuestionAddDto dto) {
        Question question = getMapper().map(dto, Question.class);
        question.setQuestionDate(LocalDateTime.now());
        setTechnology(question, dto.getTechnologyId());
        questions.save(question);
        return new IdentifierDto(question.getId());
    }

    @Transactional(readOnly = false)
    @Override
    public void update(Long id, QuestionUpdateDto dto) {
        Question question = questions.findById(id).orElseThrow(NotFoundException::new);
        getMapper().map(dto, question);
        setTechnology(question, dto.getTechnologyId());
        questions.save(question);
    }

    @Transactional(readOnly = false)
    @Override
    public void remove(Long id) {
        if (!questions.existsById(id))
            throw (new NotFoundException());

        answers.deleteByQuestionId(id);
        questions.deleteById(id);

    }

    @Transactional(readOnly = true)
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
