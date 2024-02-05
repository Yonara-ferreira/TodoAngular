package com.br.todo.Project.Domain;

import com.br.todo.Project.Domain.DTO.TodoCreatingData;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private LocalDateTime completionDate;
    private Boolean completed = false;


    public Todo(TodoCreatingData todoCreatingData) {
        this.id = todoCreatingData.id();
        this.title = todoCreatingData.title();
        this.description = todoCreatingData.description();
        this.completionDate = todoCreatingData.completionDate();
        this.completed = todoCreatingData.completed();

    }
}
