package com.example.demo.controller;

import com.example.demo.model.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from backend";
    }

    @GetMapping("/task")
    public Task getTask () {
        Task task = new Task();
        task.setId(1L);
        task.setTitle("My first task");
        return task;
    }
}
