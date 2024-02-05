package com.br.todo.Project.repository;


import com.br.todo.Project.Domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query("SELECT t FROM Todo t WHERE t.completed = false ORDER BY t.completionDate")
    List<Todo> findAllOpen();
    @Query("SELECT t FROM Todo t WHERE t.completed = true ORDER BY t.completionDate")
    List<Todo>  findAllClose();


}
