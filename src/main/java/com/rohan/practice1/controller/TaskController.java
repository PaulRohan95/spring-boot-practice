package com.rohan.practice1.controller;

import com.rohan.practice1.entity.TaskEntity;
import com.rohan.practice1.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")

public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
        @PostMapping
        public TaskEntity createTask(@RequestBody TaskEntity task) {
            return taskService.createTask(task);
        }

        @GetMapping
        public List<TaskEntity> getAllTasks() {
                return taskService.getAllTasks();
            }
        @GetMapping("/{id}")
        public Optional<TaskEntity> getTaskById(@PathVariable Long id) {
            return taskService.getTaskById(id);
        }

        @PutMapping("/{id}")
        public TaskEntity updateTaskById(@PathVariable Long id, @RequestBody TaskEntity task) {
            return taskService.updateTaskById(id, task);
        }


        @DeleteMapping("/{id}")
        public void deleteTaskById(@PathVariable Long id) {
            taskService.deleteTaskById(id);
        }
}
