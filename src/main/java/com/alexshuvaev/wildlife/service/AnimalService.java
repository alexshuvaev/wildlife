package com.alexshuvaev.wildlife.service;

import com.alexshuvaev.wildlife.entity.Animal;
import com.alexshuvaev.wildlife.repository.RootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AnimalService extends AbstractService<Animal> implements RootService<Animal> {

    @Autowired
    public AnimalService(@Qualifier("animalRepository") RootRepository<Animal> repository) {
        super(repository);
    }

    @Override
    public Page<Animal> getAll(Pageable pageRequest) {
        return super.getAll(pageRequest);
    }

    @Override
    public Animal get(int id) {
        return super.get(id);
    }

    @Override
    public Animal create(Animal creatable) {
        return super.create(creatable);
    }

    @Override
    public void update(Animal updatable, int id) {
        super.update(updatable, id);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }
}
