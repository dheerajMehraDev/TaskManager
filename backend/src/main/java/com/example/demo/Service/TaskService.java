package com.example.demo.Service;

import com.example.demo.Entity.Task;
import com.example.demo.Exceptions.TaskNotFoundException;
import com.example.demo.Repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;
    public Task createTask(Task task){
        if(task != null){
           return taskRepository.save(task);
        } else {
            System.out.println("task is null");
          throw new TaskNotFoundException("task not found for task id " + task.getId());
        }
    }
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    public Task getTaskById(Long id){
        if(id != null){
           Task task  = taskRepository.findById(id).orElse(null);
           if(task == null) throw new TaskNotFoundException("task not found for the task id " + id);
           else return task;
        } else {
            System.out.println("id is null");
            throw new TaskNotFoundException("task not found for task id " +id);
        }
    }
    public Task updateTask( @Valid Task task){
        Task taskFromDb = taskRepository.findById(task.getId()).orElse(null);
        if(taskFromDb != null){
            return taskRepository.save(task);
        } else {
            System.out.println("task does not exist for the given id " + task.getId());
            throw new TaskNotFoundException("task not found for task id " + task.getId());
        }
    }

    public boolean deleteTask(Long id){
        if(id != null){
             taskRepository.deleteById(id);
            System.out.println("task deleted for the id " + id);
            return true;
        } else{
            System.out.println("id is null for the delete task");
            return false;
        }
    }
    public Task updateDueDateOfTheTask(Long id, Date dueDate){
        if(id != null){
            Task task = taskRepository.findById(id).orElse(null);
            if(task != null){
                task.setDueDate(dueDate);
                return taskRepository.save(task);
            } else {
                System.out.println("task does not exist for the id " + id);
                throw new TaskNotFoundException("task not found for task id " + task.getId());
            }
        }else{
            System.out.println(" id is null for updating the due date");
           return null;
        }

    }
}
