package com.example.demo.controller;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    private final TaskService taskService;

    public TestController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/tasks")
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

}
