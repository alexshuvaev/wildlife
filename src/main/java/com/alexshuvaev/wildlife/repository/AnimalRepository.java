package com.alexshuvaev.wildlife.repository;

import com.alexshuvaev.wildlife.entity.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends RootRepository<Animal> {
    @Query(value = "Select a From Animal a join fetch a.animalType join fetch a.territory ",
            countQuery = "select count (a) from Animal a ")
    @Override
    Page<Animal> findAll(Pageable pageable);
}
