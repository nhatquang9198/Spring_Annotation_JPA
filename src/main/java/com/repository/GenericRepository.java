package com.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepository<T> extends CrudRepository<T, Long> {

}
