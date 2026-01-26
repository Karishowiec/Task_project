package com.example.demo.service;

import com.example.demo.exception.TaskNotFoundException;
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

    public Task update(Long id, Task updatedTask) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException(id));
        task.setTitle(updatedTask.getTitle());


        return repository.save(task);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
