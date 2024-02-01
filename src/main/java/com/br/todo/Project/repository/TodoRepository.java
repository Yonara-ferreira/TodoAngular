package com.br.todo.Project.repository;

import com.br.todo.Project.Domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
}
