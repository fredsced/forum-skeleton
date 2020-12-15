package fr.formation.training.forum.repositories;

import fr.formation.training.forum.dtos.TechnologyViewDto;
import fr.formation.training.forum.entities.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TechnologyJpaRepository
        extends JpaRepository<Technology, Long> {

    @Query("select new fr.formation.training.forum.dtos.TechnologyViewDto"
            + "(t.id, t.name, t.rating) "
            + "from Technology t order by t.rating desc")
    List<TechnologyViewDto> getAllProjected();

    @Query("select new fr.formation.training.forum.dtos.TechnologyViewDto"
            + "(t.id, t.name, t.rating) from Technology t where t.id = :id")
    Optional<TechnologyViewDto> findProjectedById(Long id);
}
