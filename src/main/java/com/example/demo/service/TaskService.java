package com.example.demo.service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<Task> getAll() {
        return  repository.findAll();
    }

    public Task create(Task task) { return repository.save(task);}

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Task update(Long id, Task updatedTask) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(updatedTask.getTitle());

        return repository.save(task);
    }
}
