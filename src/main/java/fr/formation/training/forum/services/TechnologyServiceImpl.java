package fr.formation.training.forum.services;

import fr.formation.training.forum.NotFoundException;
import fr.formation.training.forum.dtos.TechnologyViewDto;
import fr.formation.training.forum.repositories.TechnologyJpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    private final TechnologyJpaRepository technologies;

    public TechnologyServiceImpl(TechnologyJpaRepository technologies) {
        this.technologies = technologies;
    }

    @Transactional(readOnly = true)
    @Override
    public TechnologyViewDto getOne(Long id) {
        return technologies.findProjectedById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional(readOnly = true)
    @Override
    public List<TechnologyViewDto> getAll() {
        return technologies.getAllProjected();
    }
}
