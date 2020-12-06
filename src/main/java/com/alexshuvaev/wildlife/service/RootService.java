package com.alexshuvaev.wildlife.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RootService<T> {
    Page<T> getAll(Pageable pageRequest);
    T get(int id);
    T create(T creatable);
    void update(T updatable, int id);
    void delete(int id);

}
