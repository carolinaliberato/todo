package com.javastart.todolist.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.javastart.todolist.model.Task;
import com.javastart.todolist.service.TaskService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
@AllArgsConstructor
public class TaskController {

    TaskService taskService;

    @Operation(summary = "Criando uma nova tarefa")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Tarefa criada com sucesso",content = @Content),
    @ApiResponse(responseCode = "500", description = "Houve um erro ao criar uma nova tarefa",content = @Content) })

    @PostMapping("/tasks")
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @Operation(summary = "Listando todas as tarefas")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Tarefas listadas com sucesso",content = @Content),
    @ApiResponse(responseCode = "500", description = "Houve um erro ao listar as tarefas", content = @Content) })

    @GetMapping("/tasks")
    @ResponseStatus(HttpStatus.OK)
    public List<Task> getAllTasks() {
        return taskService.listAllTasks();
    }

    @Operation(summary = "Buscando uma tarefa pelo id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Tarefa encontrada com sucesso",content = @Content),
    @ApiResponse(responseCode = "404", description = "Houve um erro ao encontrar a tarefa", content = @Content) })

    @GetMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> getTaskById(@PathVariable (value = "id") Long id) {
        return taskService.findTaskById(id);
    }

    @Operation(summary = "Atualizando uma nova tarefa")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Tarefa atualizada com sucesso",content = @Content),
    @ApiResponse(responseCode = "404", description = "Houve um erro ao atualizar a tarefa", content = @Content) })
    
    @PutMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Task> updateTaskById(@PathVariable (value = "id") Long id, @RequestBody Task task) {
        return taskService.updateTaskById(task,id);
    }

    @Operation(summary = "Excluindo uma nova tarefa")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Tarefa excluida com sucesso",content = @Content),
    @ApiResponse(responseCode = "404", description = "Houve um erro ao excluir a tarefa", content = @Content) })
    
    @DeleteMapping("/tasks/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteTaskById(@PathVariable (value = "id") Long id) {
        return taskService.deleteById(id);
    }


}