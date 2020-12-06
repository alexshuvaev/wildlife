package com.alexshuvaev.wildlife.rest;

import com.alexshuvaev.wildlife.service.RootService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public abstract class AbstractController<T> {
    protected static final String DEFAULT_PAGE_SIZE = "100";
    protected static final String DEFAULT_PAGE_NUM = "0";

    private final RootService<T> service;

    public AbstractController(RootService<T> service) {
        this.service = service;
    }

    public Page<T> getAll(Integer page, Integer size) {
        return service.getAll(PageRequest.of(page, size, Sort.by("id")));
    }

    public T get(int id) {
        return service.get(id);
    }

    public T create(T creatable) {
        return service.create(creatable);
    }

    public void update(T updatable, int id) {
        service.update(updatable, id);
    }

    public void delete(int id) {
        service.delete(id);
    }
}
