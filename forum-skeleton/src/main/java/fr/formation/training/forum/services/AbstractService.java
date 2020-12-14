package fr.formation.training.forum.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractService {

    @Autowired
    private ModelMapper mapper;

    protected final ModelMapper getMapper() {
	return mapper;
    }
}
