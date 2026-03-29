package com.rohan.practice1.controller;

import com.rohan.practice1.dto.TaskRequestDTO;
import com.rohan.practice1.dto.TaskResponseDTO;
import com.rohan.practice1.entity.TaskEntity;
import com.rohan.practice1.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
// exposes REST APIs for Task operations (entry point for client requests)

public class TaskController {
    private final TaskService taskService; // Service layer dependency injected by Spring (service layer handles business logic, keeps the controller thin)

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    } // constructor based dependency injection (preferred for immutability and testing)

        @PostMapping // to handle HTTP post requests / task creation
        public ResponseEntity<TaskResponseDTO> createTask(@Valid @RequestBody TaskRequestDTO taskRequestDTO) {
            TaskResponseDTO response = taskService.createTask(taskRequestDTO);
            return ResponseEntity.ok(response);
        }
//        - Receives JSON body --> converts into a task object
//        - Delegates creation logic to service layer
//            - Returns saved task

        @GetMapping // to handle HTTP get requests / task reading
        public List<TaskEntity> getAllTasks() {
                return taskService.getAllTasks();
            }
            // - Fetches all tasks
            // - Calls service layer to return task from DB
    // - Return list of tasks

        @GetMapping("/{id}") // to handle HTTP get requests when user wants to get task by id
        public Optional<TaskEntity> getTaskById(@PathVariable Long id) {
            return taskService.getTaskById(id);
        } // Fetches task based on ID
        // Extracts ID from url
        // Returns optional (task may or may not exist)

        @PutMapping("/{id}") // to handle HTTP put (updating) requests
        public TaskEntity updateTaskById(@PathVariable Long id, @RequestBody TaskEntity task) { //get task by id first, then update the fields in the task body based on the fields defined in task entity
            return taskService.updateTaskById(id, task);
        }
        // Updates existing tasks
        // Uses ID to locate existing tasks
        // Applies updates from request body
        // Delegates update logoc to service layer


        @DeleteMapping("/{id}") // to handle HTTP delete requests
        public void deleteTaskById(@PathVariable Long id) {
            taskService.deleteTaskById(id);
        } // finds a task by ID
        // delgates deletion to the service layer
}
