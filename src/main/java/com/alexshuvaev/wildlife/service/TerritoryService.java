package com.alexshuvaev.wildlife.service;

import com.alexshuvaev.wildlife.entity.Territory;
import com.alexshuvaev.wildlife.repository.RootRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TerritoryService extends AbstractService<Territory> implements RootService<Territory> {

    @Autowired
    public TerritoryService(@Qualifier("territoryRepository") RootRepository<Territory> repository) {
        super(repository);
    }

    @Override
    public Page<Territory> getAll(Pageable pageRequest) {
        return super.getAll(pageRequest);
    }

    @Override
    public Territory get(int id) {
        return super.get(id);
    }

    @Override
    public Territory create(Territory creatable) {
        return super.create(creatable);
    }

    @Override
    public void update(Territory updatable, int id) {
        super.update(updatable, id);
    }

    @Override
    public void delete(int id) {
        super.delete(id);
    }
}
