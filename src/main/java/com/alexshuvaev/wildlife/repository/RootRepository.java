package com.alexshuvaev.wildlife.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RootRepository<T> extends JpaRepository<T, Integer> {
}
