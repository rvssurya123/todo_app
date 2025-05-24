package com.surya.demo.todos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// CRUD
@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {
}
