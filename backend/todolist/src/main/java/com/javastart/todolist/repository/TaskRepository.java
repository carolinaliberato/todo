package com.javastart.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javastart.todolist.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}