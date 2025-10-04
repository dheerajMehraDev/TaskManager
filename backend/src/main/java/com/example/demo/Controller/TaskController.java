package com.example.demo.Controller;

import com.example.demo.Entity.Task;
import com.example.demo.Service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;
    // create a task
    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody Task task){
       Task createdTask = taskService.createTask(task);
       return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@Valid @PathVariable Long id){
      Task task =  taskService.getTaskById(id);
       if(task != null){
          return ResponseEntity.ok(task);
       } else {
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("task did not found for id " + id);
       }
    }
    @PutMapping
    public ResponseEntity<?> updateTask(@Valid @RequestBody Task task){
        Task taskUpdated = taskService.updateTask(task);
        if(taskUpdated != null){
            return ResponseEntity.ok(taskUpdated);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
        }
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateDueDateOfTheTask(@Valid @RequestBody Date dueDate, @PathVariable Long id){
       Task updatedTask =  taskService.updateDueDateOfTheTask(id,dueDate);
       if(updatedTask != null){
           return ResponseEntity.ok(updatedTask);
       } else{
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("task did not got updated for id " + id);
       }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@Valid @PathVariable Long id){
        boolean deleted =  taskService.deleteTask(id);
        if(deleted){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("deleted successfully for the id " + id);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("could not be deleted for the id" + id);
        }
    }
}
