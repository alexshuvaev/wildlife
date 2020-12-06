package com.alexshuvaev.wildlife.service;

import com.alexshuvaev.wildlife.entity.AbstractEntity;
import com.alexshuvaev.wildlife.repository.RootRepository;
import com.alexshuvaev.wildlife.utils.exception.NotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class AbstractService<T extends AbstractEntity> {

    private final RootRepository<T> repository;

    public AbstractService(RootRepository<T> repository) {
        this.repository = repository;
    }

    public Page<T> getAll(Pageable pageRequest) {
        return repository.findAll(pageRequest);
    }

    public T get(int id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("no data with id=" + id));
    }

    public T create(T creatable) {
        return repository.save(creatable);
    }

    public void update(T updatable, int id) {
        AbstractEntity obj = get(id);
        updatable.setId(obj.getId());
        repository.save(updatable);
    }

    public void delete(int id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new NotFoundException("Cant be deleted. No data with id=" + id);
        }
    }

}
