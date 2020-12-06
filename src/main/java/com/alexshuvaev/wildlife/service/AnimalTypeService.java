package com.alexshuvaev.wildlife.service;

import com.alexshuvaev.wildlife.entity.AnimalType;
import com.alexshuvaev.wildlife.repository.RootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnimalTypeService extends AbstractService<AnimalType> implements RootService<AnimalType> {

    @Autowired
    public AnimalTypeService(@Qualifier("animalTypeRepository") RootRepository<AnimalType> repository) {
        super(repository);
    }

    @Override
    public Page<AnimalType> getAll(Pageable pageRequest) {
        return super.getAll(pageRequest);
    }

    @Override
    public AnimalType get(int id) {
        return super.get(id);
    }

    @Override
    public AnimalType create(AnimalType creatable) {
        return super.create(creatable);
    }

    @Override
    public void update(AnimalType updatable, int id) {
        super.update(updatable, id);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }
}
